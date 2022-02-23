package cn.chenzw.dependence.thumbnailator.samples;

import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 参考：https://github.com/coobird/thumbnailator/wiki/Examples
 */
@RunWith(JUnit4.class)
public class ThumbnailatorTests {


    /**
     * 截取部分
     * @throws IOException
     */
    @Test
    public void testCut() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("images/flower.jpg");

        // 截取300 X 100的部图片
        Thumbnails.of(is)
                .size(300, 100).sourceRegion(new Rectangle(0, 0, 300, 100)).toFile(new File("cut.png"));
    }

    /**
     * 旋转
     * @throws IOException
     */
    @Test
    public void testRotate() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("images/flower.jpg");

         Thumbnails.of(is)
                .size(200, 200)
                .rotate(90)
                 .toFile(new File("rotate.png"));
    }

    /**
     * 缩放图片
     */
    @Test
    public void testScale() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("images/flower.jpg");

        Thumbnails.of(is)
                .scale(0.2)
                .toFile(new File("scale.png"));
    }

}
