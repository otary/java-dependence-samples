package cn.chenzw.java.dependence.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(JUnit4.class)
public class QRCodeReaderTests {

    @Test
    public void testRead() throws NotFoundException, IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("qrcode/qrcode.jpg");
        BufferedImage bufferedImage = ImageIO.read(is);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)));

        // 开启精度优化与复杂模式会消耗识别时间！
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(DecodeHintType.POSSIBLE_FORMATS, Arrays.asList(BarcodeFormat.QR_CODE));//指定识别的二维码格式

        MultiFormatReader formatReader = new MultiFormatReader();
        Result result = formatReader.decode(binaryBitmap, hints);

        log.info("二维码内容 => {}", result.getText());
        log.info("二维码格式 => {}", result.getBarcodeFormat());
        log.info("二维码元数据 => {}", result.getResultMetadata());
    }
}
