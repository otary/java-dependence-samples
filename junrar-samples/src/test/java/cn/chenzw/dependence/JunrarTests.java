package cn.chenzw.dependence;

import com.github.junrar.Archive;
import com.github.junrar.Volume;
import com.github.junrar.exception.RarException;
import com.github.junrar.impl.FileVolumeManager;
import com.github.junrar.rarfile.FileHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;

/**
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class JunrarTests {

    @Test
    public void testBasic() {
        /*try (Archive archive = new Archive(new FileVolumeManager(new File("")))) {
            Volume mainVol = archive.getMainVolume();

            // 遍历RAR文件中的所有条目
            Enumeration<FileHeader> fileHeaders = mainVol.fileHeaders();
            while (fileHeaders.hasMoreElements()) {
                FileHeader fileHeader = fileHeaders.nextElement();
                String entryName = fileHeader.getFileNameString();

                // 获取输出文件的完整路径
                Path outputFilePath = outputDir.resolve(entryName);

                // 跳过目录项
                if (fileHeader.isDirectory()) {
                    Files.createDirectories(outputFilePath);
                    continue;
                }

                // 创建父目录（如果不存在）
                Files.createDirectories(outputFilePath.getParent());

                try (InputStream inputStream = mainVol.getFileInputStream(fileHeader);
                     FileOutputStream outputStream = new FileOutputStream(outputFilePath.toFile())) {

                    // 将RAR文件条目写入到输出文件中
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                }
            }
        } catch (RarException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
