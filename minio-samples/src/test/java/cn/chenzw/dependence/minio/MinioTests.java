package cn.chenzw.dependence.minio;

import io.minio.*;

import io.minio.errors.*;
import io.minio.http.Method;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RunWith(JUnit4.class)
public class MinioTests {

    static MinioClient minioClient;

    static final String MINIO_BUCKET = "test";

    @BeforeClass
    public static void beforeClass() {
        // @TODO
        minioClient = MinioClient.builder()
                .endpoint("http://119.45.252.139:9020")
                .credentials("otary", "otary_321")
                .build();
    }

    /**
     * 上传
     */
    @Test
    public void testPutObject() throws Exception {
        BucketExistsArgs bucket = BucketExistsArgs.builder().bucket(MINIO_BUCKET).build();
        // bucket存在才进行上传
        if (minioClient.bucketExists(bucket)) {
            try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt")) {
                // 指定上传后的文件名、上传的bucket、上传的文件流
                PutObjectArgs args = PutObjectArgs.builder().object("rename_a.txt")
                        .bucket(MINIO_BUCKET)
                        .stream(is, is.available(), -1)
                        .build();
                minioClient.putObject(args);
            }
        } else {
            // 创建bucket
            MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder()
                    .bucket(MINIO_BUCKET)
                    .build();
            minioClient.makeBucket(makeBucketArgs);
        }
    }


    /**
     * 下载
     */
    @Test
    public void testGetObjectArgs() throws Exception {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object("rename_a.txt")
                .build();
        try (InputStream is = minioClient.getObject(getObjectArgs)) {
            File file = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "download/a.txt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            try (FileOutputStream fis = new FileOutputStream(file)) {
                IOUtils.copy(is, fis);
            }
        }
    }

    /**
     * 删除
     */
    @Test
    public void testRemoveObject() throws Exception {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object("rename_a.txt")
                .build();
        minioClient.removeObject(removeObjectArgs);
    }

    /**
     * 获取文件外链
     */
    @Test
    public void testGetPresignedObjectUrl() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, InvalidExpiresRangeException, ServerException, InternalException, NoSuchAlgorithmException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        GetPresignedObjectUrlArgs getPresignedObjectUrlArgs = GetPresignedObjectUrlArgs.builder()
                .expiry(7)  // 有效期7天（默认7天）
                .bucket("test")
                .object("rename_a.txt")
                .method(Method.GET)
                .build();
        String presignedObjectUrl = minioClient.getPresignedObjectUrl(getPresignedObjectUrlArgs);

        System.out.println(presignedObjectUrl);
    }

}