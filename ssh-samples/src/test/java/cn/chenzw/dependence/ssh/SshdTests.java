package cn.chenzw.dependence.ssh;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ChannelExec;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.config.keys.DefaultAuthorizedKeysAuthenticator;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.shell.InteractiveProcessShellFactory;
import org.apache.sshd.server.shell.ProcessShellCommandFactory;
import org.apache.sshd.sftp.client.SftpClient;
import org.apache.sshd.sftp.client.SftpClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class SshdTests {

    @Test
    public void testSSH() throws IOException {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("root", "82.157.19.141", 22).verify(10 * 1000).getSession();
        session.addPasswordIdentity("xxx");
        // session.addPublicKeyIdentity(SecurityUtils.loadKeyPairIdentity("keyname", new FileInputStream("priKey.pem"), null));
        if (!session.auth().verify(10 * 1000).isSuccess()) {
            throw new RuntimeException("auth failed");
        }
        ChannelExec channel = session.createExecChannel("ls");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        channel.setOut(out);
        channel.setErr(err);

        if (!channel.open().verify(10 * 1000).isOpened()) {
            throw new RuntimeException("open failed");
        }

        channel.waitFor(
                Arrays.asList(ClientChannelEvent.CLOSED), 10 * 1000
        );
        channel.close();

        log.info("out => {}", out);
        log.info("err => {}", err);

        client.stop();
        client.close();
    }

    /**
     * SSH服务端
     *
     * @link https://github.com/apache/mina-sshd/blob/master/docs/server-setup.md
     */
    @Test
    public void testSSHServer() throws InterruptedException {
        SshServer sshd = SshServer.setUpDefaultServer();
        // sshd.setHost("82.157.19.141");
        sshd.setPort(22);

        // 设置主机的私钥，用于与客户端进行密钥交换
        // sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(Paths.get("/opt/key")));
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());

        // 此处进行用户名和密码登录验证
        sshd.setPasswordAuthenticator((username, password, serverSession) -> {
            return true;
        });
        // use file ~/.ssh/authorized_keys
        sshd.setPublickeyAuthenticator(new DefaultAuthorizedKeysAuthenticator(false));

        // 设置sftp子系统
        // sshd.setSubsystemFactories(Arrays.asList(new SftpSubsystemFactory()));

        // 设置sfp默认的访问目录
        // Path dir = Paths.get("/root");
        // sshd.setFileSystemFactory(new VirtualFileSystemFactory(dir.toAbsolutePath()));

        //  给每个用户分配不同的访问目录
//        sshd.setFileSystemFactory(new VirtualFileSystemFactory(dir.toAbsolutePath()) {
//            @Override
//            public Path getUserHomeDir(SessionContext session) throws IOException {
//                String username = session.getUsername();
//                Path homeDir = getUserHomeDir(username);
//                if (homeDir == null) {
//                    //这里给每个用户修改为默认目录+用户名+dir的目录格式
//                    //可以根据实际的需求修改此处的代码
//                    homeDir = getDefaultHomeDir().resolve(username + "dir");
//                    setUserHomeDir(username, homeDir);
//                }
//                File file = new File(String.valueOf(homeDir));
//                file.mkdirs();
//                return homeDir;
//            }
//        });

        // 设置ssh的shell环境（每次用户登录并希望运行交互式 shell 时，shell 工厂将用于创建一个新 shell）
        sshd.setShellFactory((shellFactory) -> {
            ServerSession session = shellFactory.getSession();
            String username = session.getUsername();
            // 除了root以外的的用户都不允许远程登录
            if ("root".equals(username)) {
                return InteractiveProcessShellFactory.INSTANCE.createShell(shellFactory);
            } else {
                return null;
            }
        });

        // 提供了运行单个命令的能力（而不是交互式会话的能力） - 如果未配置，则客户端发送的任何直接命令都将被拒绝
        sshd.setCommandFactory(new ProcessShellCommandFactory());

        //启动ssh服务
        try {
            sshd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TimeUnit.HOURS.sleep(1);
    }

    /**
     * @link https://github.com/apache/mina-sshd/blob/master/docs/sftp.md
     */
    @Test
    public void testSFTP() throws IOException {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("root", "82.157.19.141", 22).verify().getSession();
        session.addPasswordIdentity("xxxx");
        session.auth().verify();

        SftpClient sftp = SftpClientFactory.instance().createSftpClient(session);

        // 读目录
        Iterable<SftpClient.DirEntry> dirEntries = sftp.readDir("/root");
        for (SftpClient.DirEntry dirEntry : dirEntries) {
            log.info("dirEntry => {}", dirEntry);
        }

        // 读文件
        String str = IOUtils.toString(sftp.read("/root/.ssh/known_hosts"), StandardCharsets.UTF_8);
        log.info("read => {}", str);

        // 创建文件
        // sftp.mkdir("/root/a.txt");

        // 获取属性
        SftpClient.Attributes attrs = sftp.lstat("/root/.ssh/known_hosts");
        log.info("attrs => {}", attrs);

        // 获取属性2
        SftpClient.Attributes attrs2 = sftp.stat("/root/.ssh/known_hosts");
        log.info("attrs2 => {}", attrs2);

        OutputStream os = sftp.write("/root/c.txt");
        IOUtils.write("xxx", os, StandardCharsets.UTF_8);
        os.close();

        session.close(false);
        client.stop();
    }

    @Test
    public void testSFTP2() {
        try (SshClient client = SshClient.setUpDefaultClient()) {
            client.start();
            try (ClientSession session = client.connect("root", "82.157.19.141", 22).verify().getSession()) {
                session.addPasswordIdentity("Otary_321");
                session.auth().verify();

                try (SftpClient sftp = SftpClientFactory.instance().createSftpClient(session)) {
                    SftpClient.CloseableHandle handle = sftp.open("/root", EnumSet.of(SftpClient.OpenMode.Write, SftpClient.OpenMode.Create));


                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
