package cn.chenzw.dependence.tess4j;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class BasicTests {


    /**
     * 一、PageSegMode（图片分割模式）：
     *     0 – Orientation and script detection (OSD) only. 方向及语言检测（Orientation and script detection，OSD)
     *     1 – Automatic page segmentation with OSD. 自动图片分割
     *     2 – Automatic page segmentation, but no OSD, or OCR. 自动图片分割，没有OSD和OCR
     *     3 – Fully automatic page segmentation, but no OSD. (Default) 完全的自动图片分割，没有OSD
     *     4 – Assume a single column of text of variable sizes. 假设有一列不同大小的文本
     *     5 – Assume a single uniform block of vertically aligned text. 假设有一个垂直对齐的文本块
     *     6 – Assume a single uniform block of text. 假设有一个对齐的文本块
     *     7 – Treat the image as a single text line. 图片为单行文本
     *     8 – Treat the image as a single word. 图片为单词
     *     9 – Treat the image as a single word in a circle. 图片为圆形的单词
     *     10 – Treat the image as a single character. 图片为单个字符
     *     11 – Sparse text. Find as much text as possible in no particular order. 稀疏文本。查找尽可能多的文本，没有特定的顺序。
     *     12 – Sparse text with OSD. OSD稀疏文本
     *     13 – Raw line. Treat the image as a single text line, bypassing hacks that are Tesseract-specific. 原始行。将图像视为单个文本行。
     *
     *  二、OCR引擎模式
     *     0 – Legacy engine only.
     *     1 – Neural nets LSTM engine only.
     *     2 – Legacy + LSTM engines.
     *     3 – Default, based on what is available.
     *
     */
    @Test
    public void test() throws TesseractException {
        String filePath = Thread.currentThread().getContextClassLoader().getResource("test.png").getPath();
        String tessdataPath = Thread.currentThread().getContextClassLoader().getResource("tessdata/fast").getFile();

        long t1 = System.currentTimeMillis();
        Tesseract tesseract = new Tesseract();
        // 设置训练数据文件夹路径
        tesseract.setDatapath(new File(tessdataPath).getPath());
        tesseract.setLanguage("chi_sim");
        // 可设置多个，用加号间隔
        // tesseract.setLanguage("chi_sim+eng");

        // 只提取数字
        // tesseract.setConfigs(Arrays.asList("digits"));

        // tesseract.setOcrEngineMode(1); // 设置OCR引擎模式（OEM）
        // tesseract.setPageSegMode(6);   // 设置图片分割模式（PSM）

        String text = tesseract.doOCR(new File(filePath));
        long t2 = System.currentTimeMillis();
        log.info("cost => {} ms", t2 - t1);
        log.info("text => {}", text);
    }
}

