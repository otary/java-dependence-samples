package cn.chenzw.dependence.hutool;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class DESTests {

    private static final String KEY = "5Sa8lKie5lE=";

    private static final DES DES = SecureUtil.des(SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue(), KEY.getBytes()).getEncoded());


    @Test
    public void testEncryptHex() {
        String hex = DES.encryptHex("Test");
        Assert.assertEquals("e5cac30bd862e21e", hex);
    }

    @Test
    public void testDecryptData() {
        String str = DES.decryptStr("e5cac30bd862e21e");
        Assert.assertEquals("Test", str);
    }
}
