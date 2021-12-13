package cn.chenzw.java.dependence.uasparser;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class UasparserTests {

    private static UASparser uasParser = null;

    static {
        try {
            uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
        String str = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36";
        try {
            UserAgentInfo userAgentInfo = uasParser.parse(str);
            System.out.println("操作系统名称：" + userAgentInfo.getOsFamily());//
            System.out.println("操作系统：" + userAgentInfo.getOsName());//
            System.out.println("浏览器名称：" + userAgentInfo.getUaFamily());//
            System.out.println("浏览器版本：" + userAgentInfo.getBrowserVersionInfo());//
            System.out.println("设备类型：" + userAgentInfo.getDeviceType());
            System.out.println("浏览器:" + userAgentInfo.getUaName());
            System.out.println("类型：" + userAgentInfo.getType());
            System.out.println(userAgentInfo.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
