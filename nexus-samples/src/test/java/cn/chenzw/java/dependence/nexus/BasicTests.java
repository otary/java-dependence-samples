package cn.chenzw.java.dependence.nexus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class BasicTests {

    @Test
    public void test() {
        /*final ConnectionInfo.ValidationLevel sslCertificateValidationLevel = parameters
                .isSslInsecure() ? ConnectionInfo.ValidationLevel.LAX : ConnectionInfo.ValidationLevel.STRICT;
        final ConnectionInfo.ValidationLevel sslCertificateHostnameValidationLevel = parameters
                .isSslAllowAll() ? ConnectionInfo.ValidationLevel.NONE : ConnectionInfo.ValidationLevel.LAX;
        final ConnectionInfo connectionInfo = new ConnectionInfo(baseUrl, authenticationInfo, proxyInfos, sslCertificateValidationLevel, sslCertificateHostnameValidationLevel);
        final NexusClient nexusClient = new JerseyNexusClientFactory(
                new JerseyStagingWorkflowV2SubsystemFactory(),
                new JerseyStagingWorkflowV3SubsystemFactory()
        ).createFor(connectionInfo);*/
    }
}
