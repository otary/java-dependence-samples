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
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no"); // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("Otary_321");
        session.connect();

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

        /*for (String cmd : cmds) {
            cmd = json2String(cmd);
            printWriter.println(cmd);
        }*/

        session.disconnect();
    }

    @Test
    public void testExec() throws JSchException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession("root", "82.157.19.141", 22);
        session.setConfig("StrictHostKeyChecking", "no");  // 第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("Otary_321");
        session.connect();

        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand("tail -f /data/modules/tools-service/app/logs/video-parse/all-2024-04-22.log");
        channelExec.setErrStream(System.err);
        channelExec.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in,
                Charset.forName("utf8")));
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            System.out.println(buf);
        }
        // String result = IOUtils.toString(in, "UTF-8");
        channelExec.disconnect();
        //logger.info("result => {}", result);
    }
}
