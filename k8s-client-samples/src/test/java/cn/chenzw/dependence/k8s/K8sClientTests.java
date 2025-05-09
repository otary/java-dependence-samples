package cn.chenzw.dependence.k8s;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.dsl.NonDeletingOperation;
import junit.framework.AssertionFailedError;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.function.Function;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class K8sClientTests {

    @Test
    public void test() {
        Config config = new ConfigBuilder().
                withMasterUrl("https://10.11.2.197:6443/")
                .withWebsocketPingInterval(5 * 60 * 1000L)
                .withMaxConcurrentRequestsPerHost(30)
                .withTrustCerts(true)
                // .withOauthToken("aaaeyJhbGciOiJSUzI1NiIsImtpZCI6IlU2NV9MNHdnNmplRVlEZWFUN0g1ck5ZcENFU1JHTEI5MGFzVkxQa3hjREkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJrdWJlcm5ldGVzLWRhc2hib2FyZC10b2tlbi1mZm5sNCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6ImY2YWMyMzdiLTI4NDYtNDExMi04MzI2LWRlYzlmMTliZTMyZSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDprdWJlcm5ldGVzLWRhc2hib2FyZDprdWJlcm5ldGVzLWRhc2hib2FyZCJ9.fknJJrNqFDdbc-U2mEcuxqhUt2y8VvZVPhR9yP6ZFuTY0CaZAwXrvblnBPSz2rKKZ2mmNshpXptBGaqrOTCROOZYBzlMpuMvLhUkz461z_ULWufFVNSaZiU11u-9NyLSTIHe8pUGHyRl4QgeIAXMZD9vGy0KTELZ_EGH9ZlHOSaF2Sw9swY0nU_SSPNYJpcYg5ONYPFk56b1SclTgCoVVjV9trmuhlIrX1XC_az8UfrXYro7KX2YqxuGDh4XSY7w45NMiDzlNx0aIAbraS2ZSaxYJoLKlTatZwvsgu9PDLohgYConQXgZSr5OkF3cBfsWV5bE8Ou9_6WbSsOIHHxHA")
                .build();

        KubernetesClient client = new KubernetesClientBuilder()
                .withConfig(config)
                .build();

        // 获取命名空间列表
        NamespaceList namespaceList = client.namespaces().list();
        log.info("namespace list => {}", namespaceList);

        // 获取单个命名空间
        Namespace defaultNamespace = client.namespaces().withName("default").get();
        log.info("get namespace [default]=> {}", defaultNamespace);

        // 对命名空间信息进行修改
        Namespace editedNamespace = client.namespaces().withName("default").edit(n -> new NamespaceBuilder(n)
                .editMetadata()
                .addToLabels("a", "11")
                .endMetadata()
                .build()
        );

        // 删除命名空间
        // List<StatusDetails> status = client.namespaces().withName("default").delete();
        // log.info("delete namespace[default] => {}", status);

        // 获取所有Service
        ServiceList serviceList = client.services().list();
        log.info("All service list => {}", serviceList);

        // 获取指定命名空间下的Service
        ServiceList serviceList2 = client.services().inNamespace("default").list();
        log.info("namespace[default] service list => {}", serviceList2);


        // 获取指定命名空间下的Pod列表
        PodList podList = client.pods().inNamespace("default").list();
        log.info("pod list => {}", podList);


    }

    @Test
    public void testEvents() {
        Config config = new ConfigBuilder().withMasterUrl("https://mymaster.com").build();
        KubernetesClient client = new KubernetesClientBuilder()
                .withConfig(config)
                .build();


        Watch watch = client.pods().inNamespace("default").withName("pod1").watch(new Watcher<Pod>() {
            @Override
            public void eventReceived(Action action, Pod resource) {
                switch (action) {
                    case DELETED:

                        break;
                    default:
                        throw new AssertionFailedError(action.toString().concat(" isn't recognised."));
                }
            }

            @Override
            public void onClose(WatcherException cause) {

            }
        });
    }
}
