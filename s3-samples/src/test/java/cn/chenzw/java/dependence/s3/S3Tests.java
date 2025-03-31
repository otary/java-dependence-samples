package cn.chenzw.java.dependence.s3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import software.amazon.awssdk.services.s3.S3Client;

/**
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class S3Tests {

    @Test
    public void test() {

        S3Client.builder()
                // .region(Region.US_WEST_2)
                .build();
    }
}
