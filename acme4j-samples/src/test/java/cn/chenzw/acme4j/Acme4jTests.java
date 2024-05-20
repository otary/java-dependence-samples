package cn.chenzw.acme4j;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.cmp.Challenge;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.shredzone.acme4j.*;
import org.shredzone.acme4j.challenge.Dns01Challenge;
import org.shredzone.acme4j.challenge.Http01Challenge;
import org.shredzone.acme4j.exception.AcmeException;
import org.shredzone.acme4j.provider.ChallengeType;
import org.shredzone.acme4j.util.CSRBuilder;
import org.shredzone.acme4j.util.KeyPairUtils;
import org.springframework.beans.factory.parsing.Problem;

import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.security.KeyPair;
import java.security.Security;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class Acme4jTests {

    // 申请的域名
    private List<String> domains = Arrays.asList("yl.bqrdh.com");

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws IOException
     * @throws AcmeException
     */
    @Test
    public void test() throws IOException, AcmeException {

        KeyPair userKeyPair = KeyPairUtils.createKeyPair();

        /**
         * {
         *   "keyChange": "https://acme-v02.api.letsencrypt.org/acme/key-change",
         *   "meta": {
         *     "caaIdentities": [
         *       "letsencrypt.org"
         *     ],
         *     "termsOfService": "https://letsencrypt.org/documents/LE-SA-v1.4-April-3-2024.pdf",
         *     "website": "https://letsencrypt.org"
         *   },
         *   "muL7lJGjzo0": "https://community.letsencrypt.org/t/adding-random-entries-to-the-directory/33417",
         *   "newAccount": "https://acme-v02.api.letsencrypt.org/acme/new-acct",
         *   "newNonce": "https://acme-v02.api.letsencrypt.org/acme/new-nonce",
         *   "newOrder": "https://acme-v02.api.letsencrypt.org/acme/new-order",
         *   "renewalInfo": "https://acme-v02.api.letsencrypt.org/draft-ietf-acme-ari-02/renewalInfo/",
         *   "revokeCert": "https://acme-v02.api.letsencrypt.org/acme/revoke-cert"
         * }
         */
        Session session = new Session("https://acme-v02.api.letsencrypt.org/directory");

        // 用于提示（Do you accept the Terms of Service?）
        // URI toc = session.getMetadata().getTermsOfService();

        AccountBuilder accountBuilder = new AccountBuilder()
                .agreeToTermsOfService()
                .useKeyPair(userKeyPair);

        // 非必填？
        accountBuilder.addEmail("656469722@qq.com");

        // Use the KID and HMAC if the CA uses External Account Binding
        // accountBuilder.withKeyIdentifier(EAB_KID, EAB_HMAC);

        // 创建账号
        Account account = accountBuilder.create(session);

        // 域名密钥对
        KeyPair domainKeyPair = KeyPairUtils.createKeyPair(4096);

        // 订购证书
        Order order = account.newOrder().domains(domains).create();

        // 授权
        for (Authorization auth : order.getAuthorizations()) {
            if (auth.getStatus() == Status.VALID) {
                return;
            }

            // 方式一：HTTP方式质询
            Http01Challenge challenge = auth.findChallenge(Http01Challenge.class);
            if (challenge == null) {
                throw new AcmeException("Found no " + Http01Challenge.TYPE + " challenge, don't know what to do...");
            }

            log.info("Please create a file in your web server's base directory.");
            log.info("It must be reachable at: http://{}/.well-known/acme-challenge/{}",
                    auth.getIdentifier().getDomain(), challenge.getToken());
            log.info("File name: {}", challenge.getToken());
            log.info("Content: {}", challenge.getAuthorization());
            log.info("The file must not contain any leading or trailing whitespaces or line breaks!");
            log.info("If you're ready, dismiss the dialog...");

            StringBuilder message = new StringBuilder();
            message.append("Please create a file in your web server's base directory.\n\n");
            message.append("http://")
                    .append(auth.getIdentifier().getDomain())
                    .append("/.well-known/acme-challenge/")
                    .append(challenge.getToken())
                    .append("\n\n");
            message.append("Content:\n\n");
            message.append(challenge.getAuthorization());
            log.info("message => {}", message);

            // 此时需要手动将content内容写入到acme-challenge下的文件中
            
            // 方式二：DNS方式质询
            /*
            Dns01Challenge challenge = auth.findChallenge(Dns01Challenge.TYPE)
            if (challenge == null) {
                throw new AcmeException("Found no " + Http01Challenge.TYPE + " challenge, don't know what to do...");
            }
            log.info("Please create a TXT record:");
            log.info("{} IN TXT {}",
                    Dns01Challenge.toRRName(auth.getIdentifier()), challenge.getDigest());
            log.info("If you're ready, dismiss the dialog...");

            StringBuilder message = new StringBuilder();
            message.append("Please create a TXT record:\n\n");
            message.append(Dns01Challenge.toRRName(auth.getIdentifier()))
                    .append(" IN TXT ")
                    .append(challenge.getDigest());
            log.info("message => {}", message);
            */

            if (challenge == null) {
                throw new AcmeException("No challenge found");
            }
            if (challenge.getStatus() == Status.VALID) {
                return;
            }
            // 开始质询
            challenge.trigger();

            try {
                int attempts = 10;
                while (challenge.getStatus() != Status.VALID && attempts-- > 0) {
                    // Did the authorization fail?
                    if (challenge.getStatus() == Status.INVALID) {
                        log.error("Challenge has failed, reason: {}", challenge.getError());
                        throw new AcmeException("Challenge failed... Giving up.");
                    }

                    // Wait for a few seconds
                    Thread.sleep(3000L);

                    // Then update the status
                    challenge.update();
                }
            } catch (InterruptedException ex) {
                log.error("interrupted", ex);
                Thread.currentThread().interrupt();
            }

            if (challenge.getStatus() != Status.VALID) {
                throw new AcmeException("Failed to pass the challenge for domain "
                        + auth.getIdentifier().getDomain() + ", ... Giving up.");
            }

            log.info("Challenge has been completed. Remember to remove the validation resource.");
        }

        // Generate a CSR for all of the domains, and sign it with the domain key pair.
        CSRBuilder csrb = new CSRBuilder();
        csrb.addDomains(domains);
        csrb.sign(domainKeyPair);

        /*
        try (Writer out = new FileWriter(DOMAIN_CSR_FILE)) {
            csrb.write(out);
        }
        */

        // 发起订购
        order.execute(csrb.getEncoded());

        // Wait for the order to complete
        try {
            int attempts = 10;
            while (order.getStatus() != Status.VALID && attempts-- > 0) {
                // Did the order fail?
                if (order.getStatus() == Status.INVALID) {
                    log.error("Order has failed, reason: {}", order.getError());
                    throw new AcmeException("Order failed... Giving up.");
                }

                // Wait for a few seconds
                Thread.sleep(3000L);

                // Then update the status
                order.update();
            }
        } catch (InterruptedException ex) {
            log.error("interrupted", ex);
            Thread.currentThread().interrupt();
        }

        // Get the certificate
        Certificate certificate = order.getCertificate();

        log.info("Success! The certificate for domains {} has been generated!", domains);
        log.info("Certificate URL: {}", certificate.getLocation());

        // Write a combined file containing the certificate and chain.
        try (FileWriter fw = new FileWriter(new File("domain-chain.crt"))) {
            certificate.writeCertificate(fw);
        }

    }

}
