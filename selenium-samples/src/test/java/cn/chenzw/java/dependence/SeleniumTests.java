package cn.chenzw.java.dependence;

import cn.chenzw.toolkit.commons.ProjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class SeleniumTests {

    @Test
    public void testChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ProjectUtils.getClassPath() + "driver/chrome/86/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://passport.jd.com/new/login.aspx");
        System.out.println(webDriver.getPageSource());
        webDriver.quit();
    }

    @Test
    public void testPhantomJsDriver() {
        System.setProperty("phantomjs.binary.path", ProjectUtils.getClassPath() + "driver/phantomjs/phantomjs.exe");
        WebDriver webDriver = new PhantomJSDriver();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://passport.jd.com/new/login.aspx");
        System.out.println(webDriver.getPageSource());
        webDriver.quit();
    }

    @Test
    public void testFirefoxDriver() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://passport.jd.com/new/login.aspx");
        System.out.println(webDriver.getPageSource());
        webDriver.quit();
    }


    /**
     * 使用代理
     */
    @Test
    public void testProxy() {
        System.setProperty("webdriver.chrome.driver", ProjectUtils.getClassPath() + "driver/chrome/86/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        // 设置代理
        String proxyServer = "192.168.13.19:7777";
        Proxy proxy = new Proxy().setHttpProxy(proxyServer).setSslProxy(proxyServer);
        chromeOptions.setProxy(proxy);

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://passport.jd.com/new/login.aspx");
        System.out.println(webDriver.getPageSource());
        webDriver.quit();
    }

}
