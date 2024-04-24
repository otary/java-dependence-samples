package cn.chenzw.dependence.jsch;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;

@RunWith(JUnit4.class)
public class JschTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * shell模式 - 长时间连接（如：查看实时日志等）
     *
     * @throws IOException
     * @throws JSchException
     */
    @Test
    public void testShell() throws IOException, JSchException {
        // 构建session会话
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no"); // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("xxx");

        // 会话连接
        if (!session.isConnected()) {
            session.connect();
        }

        // 创建Channel连接
        ChannelShell channelShell = (ChannelShell) session.openChannel("shell");
        InputStream inputStream = channelShell.getInputStream(); // 从远端到达的数据都能从这个流读取到
        channelShell.setPty(true);

        channelShell.connect();

        OutputStream outputStream = channelShell.getOutputStream(); // 写入该流的数据都将发送到远程端
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("tail -f /data/modules/tools-service/app/logs/video-parse/all-2024-04-22.log");
        printWriter.println("exit"); // 为了结束本次交互
        printWriter.flush(); // 把缓冲区的数据强行输出

        byte[] tmp = new byte[1024];
        while (true) {
            while (inputStream.available() > 0) {
                int i = inputStream.read(tmp, 0, 1024);
                if (i < 0) break;
                String s = new String(tmp, 0, i);
                if (s.indexOf("--More--") >= 0) {
                    outputStream.write((" ").getBytes());
                    outputStream.flush();
                }
                logger.info(" => {}", s);
            }
            if (channelShell.isClosed()) {
                logger.info("exitStatus => {}", channelShell.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        outputStream.close();
        inputStream.close();
        channelShell.disconnect();
        session.disconnect();
    }

    /**
     * 执行一次命令
     *
     * @throws JSchException
     * @throws IOException
     */
    @Test
    public void testExec() throws JSchException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no");  // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("xxxx");
        session.connect();

        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand("ls");
        channelExec.setErrStream(System.err);
        channelExec.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("utf8")));
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            logger.info("buf => {}", buf);
        }
        // String result = IOUtils.toString(in, "UTF-8");
        channelExec.disconnect();
        // logger.info("result => {}", result);
    }

    /**
     * 上传文件
     *
     * @throws JSchException
     * @throws SftpException
     * @throws IOException
     */
    @Test
    public void testUploadFile() throws JSchException, SftpException, IOException {
        // 构建session会话
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no"); // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("xxxx");
        session.connect();

        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt");
        // sftp.setInputStream(is);
        sftp.put(is, "/root/b.txt");
        is.close();
    }

    /**
     * 下载文件
     */
    @Test
    public void testDownloadFile() throws JSchException, IOException, SftpException {
        // 构建session会话
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no"); // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("xxxx");
        session.connect();

        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;
        FileOutputStream os = new FileOutputStream(new File("a.txt"));
        sftp.get("/root/b.txt", os);
        os.flush();
        os.close();
    }
}
