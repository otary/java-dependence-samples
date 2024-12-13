package cn.chenzw.dependence.compress;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

/**
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class GzipTests {

    @Test
    public void testCompress() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.tar");
        GzipCompressorOutputStream gzOS = new GzipCompressorOutputStream(new FileOutputStream("test.tar.gz"));
        int bufferSize = 10240;
        byte[] buffer = new byte[bufferSize];
        int n;
        while (-1 != (n = is.read(buffer))) {
            gzOS.write(buffer, 0, n);
        }
        gzOS.finish();
        gzOS.close();
    }

    @Test
    public void testDecompress() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.tar.gz");
        GzipCompressorInputStream gzIs = new GzipCompressorInputStream(is);
        OutputStream os = new FileOutputStream("test.tar");
        int bufferSize = 10240;
        byte[] buffer = new byte[bufferSize];
        int n;
        while (-1 != (n = gzIs.read(buffer))) {
            os.write(buffer, 0, n);
        }
        os.close();
        gzIs.close();
    }
}
