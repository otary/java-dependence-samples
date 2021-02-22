package cn.chenzw.java.dependence.poi.samples;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;


/**
 * html转doc
 */
@RunWith(JUnit4.class)
public class Html2WordTests {

    @Test
    public void test() throws FileNotFoundException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("html/index.html");

        // 创建 POIFSFileSystem 对象
        POIFSFileSystem poifs = new POIFSFileSystem();

        // 获取DirectoryEntry
        DirectoryEntry directory = poifs.getRoot();

        try {
            //创建文档,1.格式,2.HTML文件输入流
            directory.createDocument("WordDocument", is);

            //写入
            poifs.writeFilesystem(new FileOutputStream("result.doc"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
