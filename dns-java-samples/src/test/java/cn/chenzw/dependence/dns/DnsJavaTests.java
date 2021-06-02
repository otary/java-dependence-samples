package cn.chenzw.dependence.dns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.xbill.DNS.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RunWith(JUnit4.class)
public class DnsJavaTests {

    /**
     * 根据IP获取域名
     *
     * @throws UnknownHostException
     */
    @Test
    public void testGetHostName() throws UnknownHostException {
        String hostName = Address.getHostName(InetAddress.getByName("14.215.177.166"));

        log.info("Address.getHostName => {}", hostName);
    }

    /**
     * 根据域名获取IP
     */
    @Test
    public void testGetAllByName() throws UnknownHostException {
        String name = "www.baidu.com";
        InetAddress[] addresses = InetAddress.getAllByName(name);
        for (int i = 0; i < addresses.length; i++) {
            log.info("{} => {}", name, addresses[i].getHostAddress());
        }
    }

    @Test
    public void testLookup() throws TextParseException {
        Record[] records = null;
        Lookup lookup = new Lookup("baidu.com", Type.MX);
        lookup.run();

        if (lookup.getResult() == Lookup.SUCCESSFUL) {
            records = lookup.getAnswers();
        } else {
            log.info(" => {}", "未查询到结果!");
            return;
        }

        for (int i = 0; i < records.length; i++) {
            MXRecord mx = (MXRecord) records[i];
            log.info("Host {} has preference => {}", mx.getTarget(), mx.getPriority());
        }
    }
}
