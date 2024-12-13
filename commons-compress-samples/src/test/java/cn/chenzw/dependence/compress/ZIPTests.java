package cn.chenzw.dependence.compress;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.NullInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Slf4j
@RunWith(JUnit4.class)
public class ZIPTests {


    /**
     * 方式一：ZipOutputStream压缩（JDK自带）
     *
     * @throws IOException
     */
    @Test
    public void testCompress() throws IOException {
        File afile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/a.txt").getFile()
        );
        File bfile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/b.txt").getFile()
        );
        List<File> files = Arrays.asList(afile, bfile);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("rst.zip")));
        for (File file : files) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int len;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
        }
        zos.finish();
        zos.close();
    }

    /**
     * 方式二：NIO方式压缩
     */
    @Test
    public void testCompress2() throws IOException {
        File afile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/a.txt").getFile()
        );
        File bfile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/b.txt").getFile()
        );
        List<File> files = Arrays.asList(afile, bfile);

        ZipOutputStream zos = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(new File("rst.zip"))
                )
        );
        WritableByteChannel wbc = Channels.newChannel(zos);
        for (File file : files) {
            // 创建ZIP实体，并添加进压缩包
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            // 读取待压缩的文件并写进压缩包里
            FileInputStream fis = new FileInputStream(file);
            FileChannel fileChannel = fis.getChannel();
            fileChannel.transferTo(0, file.length() - 1, wbc);
        }

        zos.close();
        wbc.close();
    }

    /**
     * 方式三：commons-compress包
     *
     * @throws IOException
     */
    @Test
    public void testCompress3() throws IOException {
        File afile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/a.txt").getFile()
        );
        File bfile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/b.txt").getFile()
        );
        List<File> files = Arrays.asList(afile, bfile);
        ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(new File("a.zip"));
        // Zip64Mode 枚举有 3 个值：
        // - Always：对所有条目使用 Zip64 扩展
        // - Never：不对任何条目使用Zip64扩展
        // - AsNeeded：对需要的所有条目使用Zip64扩展
        zaos.setUseZip64(Zip64Mode.AsNeeded);  // 是否使用 Zip64 扩展。
        for (File file : files) {
            // 添加压缩文件
            ZipArchiveEntry zae = new ZipArchiveEntry(file.getName());
            // 指定压缩算法（非必须）
            // zae.setMethod(ZipArchiveEntry.DEFLATED);
            zaos.putArchiveEntry(zae);
            // 获取源文件输入流
            FileInputStream is = new FileInputStream(file);
            byte[] buffer = new byte[1024 * 5];
            int len = -1;
            // 每次读取的字节大小
            while ((len = is.read(buffer)) != -1) {
                //把缓冲区的字节写入到 ZipArchiveEntry
                zaos.write(buffer, 0, len);
            }
        }
        zaos.closeArchiveEntry();
        zaos.finish();
    }

    /**
     * 大文件压缩 - commons-compress
     */
    @Test
    public void testLargeCompress() throws IOException, ExecutionException, InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20),
                new ThreadFactory() {
                    private final AtomicInteger poolNumber = new AtomicInteger(1);
                    private final AtomicInteger threadNumber = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        SecurityManager sm = System.getSecurityManager();
                        ThreadGroup group = (sm != null) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
                        return new Thread(group, r, "test-" + poolNumber.getAndIncrement() + "-thread-" + threadNumber.getAndIncrement(), 0);
                    }
                }
        );
        ParallelScatterZipCreator pszc = new ParallelScatterZipCreator(executor);

        File afile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/a.txt").getFile()
        );
        File bfile = new File(
                Thread.currentThread().getContextClassLoader().getResource("pkg/b.txt").getFile()
        );
        List<File> files = Arrays.asList(afile, bfile);

        ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(new File("a.zip"));
        for (File file : files) {
            // 添加压缩文件
            ZipArchiveEntry zae = new ZipArchiveEntry(file.getName());
            // 指定压缩算法
            zae.setMethod(ZipArchiveEntry.DEFLATED);

            pszc.addArchiveEntry(zae, () -> {
                try {
                    return new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return new NullInputStream(0);
                }
            });
        }
        pszc.writeTo(zaos);
        zaos.close();
    }

    /**
     * 方法一：ZipOutputStream解压缩（JDK自带）
     */
    @Test
    public void testUnzip() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry zipEntry = null;
        byte[] buffer = new byte[1024];
        while ((zipEntry = zis.getNextEntry()) != null) {
            String fileName = zipEntry.getName();
            File file = new File(System.getProperty("user.dir") + "/zip/" + fileName);
            if (zipEntry.isDirectory()) {
                if (!file.exists()) {
                    boolean success = file.mkdirs();
                    log.info("mkdir => {} - {}", file, success);
                }
            } else {
                if (!file.getParentFile().exists()) {
                    file.mkdirs();
                }
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
            log.info("fileName => {}, size = {}, compressedSize = {}", fileName, zipEntry.getSize(), zipEntry.getCompressedSize());
        }
        zis.close();
    }

    /**
     * 方法二：
     */
    @Test
    public void testUnzip2() {

    }

    /**
     * 方式三：commons-compress解压缩
     */
    @Test
    public void testUnzip3() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.zip");
        ZipArchiveInputStream zais = new ZipArchiveInputStream(is, "UTF-8");
        ArchiveEntry archiveEntry;
        while (null != (archiveEntry = zais.getNextEntry())) {
            String fileName = archiveEntry.getName(); // 获取文件名
            File file = new File(System.getProperty("user.dir") + "/zip2/" + fileName);
            if (archiveEntry.isDirectory()) {
                if (!file.exists()) {
                    boolean success = file.mkdirs();
                    log.info("mkdir => {} - {}", file, success);
                }
            } else {
                if (!file.getParentFile().exists()) {
                    file.mkdirs();
                }
                byte[] buffer = new byte[1024 * 5];
                FileOutputStream fos = new FileOutputStream(file);
                int length = -1;
                while ((length = zais.read(buffer)) != -1) {
                    fos.write(buffer, 0, length);
                }
                fos.flush();
            }
            log.info("fileName => {}, size = {}", fileName, archiveEntry.getSize());
        }
        zais.close();
    }
}
