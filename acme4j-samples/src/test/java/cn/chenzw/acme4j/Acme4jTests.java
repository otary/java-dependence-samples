package cn.chenzw.acme4j;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.cmp.Challenge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.shredzone.acme4j.*;
import org.shredzone.acme4j.challenge.Http01Challenge;
import org.shredzone.acme4j.exception.AcmeException;
import org.shredzone.acme4j.util.KeyPairUtils;
import org.springframework.beans.factory.parsing.Problem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.security.KeyPair;
import java.util.Collection;
import java.util.Optional;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class Acme4jTests {

    @Test
    public void test() {
        if (USER_KEY_FILE.exists()) {
            // If there is a key file, read it
            try (FileReader fr = new FileReader(USER_KEY_FILE)) {
                return KeyPairUtils.readKeyPair(fr);
            }
        } else {
            // If there is none, create a new key pair and save it
            KeyPair userKeyPair = ACCOUNT_KEY_SUPPLIER.get();
            try (FileWriter fw = new FileWriter(USER_KEY_FILE)) {
                KeyPairUtils.writeKeyPair(userKeyPair, fw);
            }
            return userKeyPair;
        }

    }



  /*  private static final File USER_KEY_FILE = new File("user.key");

    private static final String CA_URI = "acme://example.com/staging";





    *//**
     * 抓取指定域名的证书
     *
     * @param domains
     * @throws IOException
     * @throws AcmeException
     *//*
    public void fetchCertificate(Collection<String> domains) throws IOException, AcmeException {
        // Load the user key file. If there is no key file, create a new one.
        KeyPair userKeyPair = loadOrCreateUserKeyPair();

        // Create a session.
        Session session = new Session(CA_URI);

        // Get the Account.
        // If there is no account yet, create a new one.
        Account acct = findOrRegisterAccount(session, userKeyPair);

        // Load or create a key pair for the domains. This should not be the userKeyPair!
        KeyPair domainKeyPair = loadOrCreateDomainKeyPair();

        // Order the certificate
        Order order = acct.newOrder().domains(domains).create();

        // Perform all required authorizations
        for (Authorization auth : order.getAuthorizations()) {
            authorize(auth);
        }

        // Order the certificate
        order.execute(domainKeyPair);

        // Wait for the order to complete
        Status status = waitForCompletion(order::getStatus, order::fetch);
        if (status != Status.VALID) {
            LOG.error("Order has failed, reason: {}", order.getError()
                    .map(Problem::toString)
                    .orElse("unknown")
            );
            throw new AcmeException("Order failed... Giving up.");
        }

        // Get the certificate
        Certificate certificate = order.getCertificate();

        log.info("Success! The certificate for domains {} has been generated!", domains);
        log.info("Certificate URL: {}", certificate.getLocation());

        // Write a combined file containing the certificate and chain.
        try (FileWriter fw = new FileWriter(DOMAIN_CHAIN_FILE)) {
            certificate.writeCertificate(fw);
        }

        // That's all! Configure your web server to use the DOMAIN_KEY_FILE and
        // DOMAIN_CHAIN_FILE for the requested domains.
    }

    *//**
     * 加载或生成用户密钥对
     *
     * @return
     * @throws IOException
     *//*
    private KeyPair loadOrCreateUserKeyPair() throws IOException {
        if (USER_KEY_FILE.exists()) {
            // If there is a key file, read it
            try (FileReader fr = new FileReader(USER_KEY_FILE)) {
                return KeyPairUtils.readKeyPair(fr);
            }
        } else {
            // If there is none, create a new key pair and save it
            KeyPair userKeyPair = ACCOUNT_KEY_SUPPLIER.get();
            try (FileWriter fw = new FileWriter(USER_KEY_FILE)) {
                KeyPairUtils.writeKeyPair(userKeyPair, fw);
            }
            return userKeyPair;
        }
    }

    *//**
     * 查找或注册账号（ACME服务器）
     *
     * @param session
     * @param accountKey
     * @return
     * @throws AcmeException
     *//*
    private Account findOrRegisterAccount(Session session, KeyPair accountKey) throws AcmeException {
        // Ask the user to accept the TOS, if server provides us with a link.
        Optional<URI> tos = session.getMetadata().getTermsOfService();
        if (tos.isPresent()) {
            acceptAgreement(tos.get());
        }

        AccountBuilder accountBuilder = new AccountBuilder()
                .agreeToTermsOfService()
                .useKeyPair(accountKey);

        // Set your email (if available)
        if (ACCOUNT_EMAIL != null) {
            accountBuilder.addEmail(ACCOUNT_EMAIL);
        }

        // Use the KID and HMAC if the CA uses External Account Binding
        if (EAB_KID != null && EAB_HMAC != null) {
            accountBuilder.withKeyIdentifier(EAB_KID, EAB_HMAC);
        }

        Account account = accountBuilder.create(session);
        log.info("Registered a new user, URL: {}", account.getLocation());

        return account;
    }

    *//**
     * 域名授权 - 账号与域名进行关联
     *
     * @param auth
     * @throws AcmeException
     *//*
    private void authorize(Authorization auth) throws AcmeException {
        log.info("Authorization for domain {}", auth.getIdentifier().getDomain());

        // The authorization is already valid. No need to process a challenge.
        if (auth.getStatus() == Status.VALID) {
            return;
        }

        // Find the desired challenge and prepare it.
        Challenge challenge = null;
        switch (CHALLENGE_TYPE) {
            case HTTP:
                challenge = httpChallenge(auth);
                break;

            case DNS:
                challenge = dnsChallenge(auth);
                break;
        }

        if (challenge == null) {
            throw new AcmeException("No challenge found");
        }

        // If the challenge is already verified, there's no need to execute it again.
        if (challenge.getStatus() == Status.VALID) {
            return;
        }

        // Now trigger the challenge.
        challenge.trigger();

        // Poll for the challenge to complete.
        Status status = waitForCompletion(challenge::getStatus, challenge::fetch);
        if (status != Status.VALID) {
            LOG.error("Challenge has failed, reason: {}", challenge.getError()
                    .map(Problem::toString)
                    .orElse("unknown"));
            throw new AcmeException("Challenge failed... Giving up.");
        }

        log.info("Challenge has been completed. Remember to remove the validation resource.");
        completeChallenge("Challenge has been completed.\nYou can remove the resource again now.");
    }

    *//**
     * 准备HTTP质询
     *
     * @param auth
     * @return
     * @throws AcmeException
     *//*
    public Challenge httpChallenge(Authorization auth) throws AcmeException {
        // Find a single http-01 challenge
        Http01Challenge challenge = auth.findChallenge(Http01Challenge.class)
                .orElseThrow(() -> new AcmeException("Found no " + Http01Challenge.TYPE
                        + " challenge, don't know what to do..."));

        // Output the challenge, wait for acknowledge...
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
        acceptChallenge(message.toString());
        return challenge;
    }*/

}
