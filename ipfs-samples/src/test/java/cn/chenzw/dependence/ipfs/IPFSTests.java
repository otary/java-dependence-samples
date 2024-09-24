package cn.chenzw.dependence.ipfs;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multiaddr.MultiAddress;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class IPFSTests {

    private IPFS ipfsClient;

    @Before
    public void before() {
        // 失败，找不到可用的节点
        this.ipfsClient = new IPFS(new MultiAddress("/dnsaddr/flk-ipfs.xyz/tcp/443/https"));
    }

    @Test
    public void testUpload() throws IOException {
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper("aaa".getBytes());
        List<MerkleNode> nodeList = this.ipfsClient.add(file);
        log.info(" => {}", nodeList);
    }
}
