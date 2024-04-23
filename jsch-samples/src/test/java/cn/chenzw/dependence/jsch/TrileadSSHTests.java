package cn.chenzw.dependence.jsch;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.StreamGobbler;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

/**
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class TrileadSSHTests {

    @Test
    public void test() {
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
            // session.requestPTY("vt100", 80, 24, 640, 480, null);

            session.requestDumbPTY();
            session.startShell();

            OutputStream stdin = session.getStdin();
            // InputStream inp = session.getStdout();
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
