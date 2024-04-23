package cn.chenzw.dependence.hutool;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.crypto.SecretKey;
import java.nio.charset.Charset;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class AESTests {

   /* private static final String KEY = "5Sa8lKie5lE=";

    private final static AES aes = SecureUtil.aes(SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), KEY.getBytes()).getEncoded());


    @Test
    public void testEncryptHex() {
        String hex = aes.encryptHex("Test");
        System.out.println(hex);
        Assert.assertEquals("e5cac30bd862e21e", hex);
    }

    public static void main(String[] args) {
        String originalData = "Hello, Hutool!";

        // 使用SecureUtil生成AES密钥
        *//*SecretKey aesKey = SecureUtil.generateKey(SymmetricAlgorithm.AES);*//*

        // 加密
        *//*byte[] encryptBytes = SymmetricCrypto.aes(aesKey.getPrivateKey().getEncoded(), aesKey.getAlgorithm()).encrypt(originalData);
        String encryptData = Base64.encode(encryptBytes);
        System.out.println("加密后的数据: " + encryptData);

        // 解密
        byte[] decryptBytes = SymmetricCrypto.aes(aesKey.getPrivateKey().getEncoded(), aesKey.getAlgorithm()).decrypt(Base64.decode(encryptData));
        String decryptData = new String(decryptBytes);
        System.out.println("解密后的数据: " + decryptData);*//*
    }*/

}
