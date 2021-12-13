package cn.chenzw.dependence.jsch;

import com.jcraft.jsch.*;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.StreamGobbler;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

@RunWith(JUnit4.class)
public class ShellTests {


    @Test
    public void test() throws JSchException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession("chenzw", "192.168.17.197", 22);
        session.setConfig("StrictHostKeyChecking", "no");//第一次访问服务器不用输入yes
        session.setTimeout(60 * 60 * 1000);
        session.setPassword("otary_321");
        session.connect();

        ChannelShell channelShell = (ChannelShell) session.openChannel("shell");
        InputStream inputStream = channelShell.getInputStream(); //从远端到达的数据  都能从这个流读取到
        channelShell.setPty(true);
        channelShell.connect();

        OutputStream outputStream = channelShell.getOutputStream(); //写入该流的数据  都将发送到远程端
        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.println("su");

        //     printWriter.println("exit");//为了结束本次交互
        printWriter.flush();//把缓冲区的数据强行输出

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

                System.out.println("------------------" + s);
            }
            if (channelShell.isClosed()) {
                System.out.println("exit-status:" + channelShell.getExitStatus());
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
    public void test2() throws InterruptedException {

        Connection conn = new Connection("192.168.17.197", 22);
        try {
            conn.connect();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            boolean sucess = conn.authenticateWithPassword("chenzw", "otary_321");
            com.trilead.ssh2.Session session = conn.openSession();
           // session.requestPTY("vt100", 132, 47, 0, 0, null);
         //   session.requestPTY("vt100", 80, 24, 640, 480, null);

            session.requestDumbPTY();
            session.startShell();

            OutputStream stdin = session.getStdin();
         //   InputStream inp = session.getStdout();
           /* InputStreamReader reader = new InputStreamReader(inp);
            BufferedReader br = new BufferedReader(reader);*/

            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(stdout));

            InputStream stderr = new StreamGobbler(session.getStderr());

            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(stderr));


            //   session.waitForCondition(4, 10000);

           new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {

                    long start = System.currentTimeMillis();

                    System.out.println("开始读取");
                  /*  String line;
                    while (true) {
                        try {
                            if ((line = br.readLine()) != null) {
                                System.out.println("----------行");
                                System.out.println(line);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }*/


                    char[] arr = new char[512];
                    int read;

                    int i = 0;

                    while (true) {
                        // 将结果流中的数据读入字符数组
                        read = br.read(arr, 0, arr.length);

                        // 推延5秒就退出[针对连通性测试会陷入死循环]
                       // if (read < 0)
                        //    break;

                        // 将结果拼装进StringBuilder
                        System.out.println(new String(arr, 0, read));
                        i++;
                    }

                }
            }).start();

            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {

                    long start = System.currentTimeMillis();

                    System.out.println("读取异常");
                  /*  String line;
                    while (true) {
                        try {
                            if ((line = br.readLine()) != null) {
                                System.out.println("----------行");
                                System.out.println(line);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }*/


                    char[] arr = new char[512];
                    int read;

                    int i = 0;

                    while (true) {
                        // 将结果流中的数据读入字符数组
                        read = br2.read(arr, 0, arr.length);

                        // 推延5秒就退出[针对连通性测试会陷入死循环]
                        if (read < 0 || (System.currentTimeMillis() - start) > 5000)
                            break;

                        // 将结果拼装进StringBuilder
                        System.out.println(new String(arr, 0, read));
                        i++;
                    }

                }
            }).start();


            System.out.println("推送命令");

            stdin.write("su\n".getBytes());
            stdin.flush();
            Thread.sleep(3000);
            stdin.write("Itm@iod#197\n".getBytes());
            stdin.flush();

            Thread.sleep(10000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
