package cn.chenzw.java.dependence;

import cn.chenzw.toolkit.commons.ProjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(JUnit4.class)
public class SeleniumTests {

    @Test
    public void testChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ProjectUtils.getClassPath() + "driver/chrome/84/chromedriver.exe");
        // 配置Chrome属性
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");

        // 去掉提示
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // 设置手机模式请求
        // chromeOptions.addArguments("---user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
        // chromeOptions.addArguments("---user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.75 Mobile Safari/537.36");
        // chromeOptions.addArguments("---user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");


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

    @Test
    public void testDemo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ProjectUtils.getClassPath() + "driver/chrome/84/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        // 加载某个页面
        webDriver.get("https://passport.jd.com/new/login.aspx");

        // 等待10s，让页面加载完成
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        // 等待直到某个元素可被点击
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='egg-stage']/div[2]")));

        // 获取页面元素对象
        WebElement element = webDriver.findElement(By.xpath("//div[@class='login-tab login-tab-r']"));
        element.click();

        // 暂停1s
        // Thread.sleep(1000L);

        // 等待直到某个元素可被点击
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='login-btn']/a")));

        // 获取页面元素文本
        String text = webDriver.findElement(By.xpath("//div[@class='login-btn']/a")).getText();
        log.info("获取元素文本 => " + text);

        // 模拟按键
        element.sendKeys(Keys.LEFT_CONTROL, Keys.LEFT_SHIFT, "M");

        // 清空Cookie
        webDriver.manage().deleteAllCookies();

        webDriver.close();

    }

}
