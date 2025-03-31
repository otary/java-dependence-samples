package cn.chenzw.dependence.ssh.core;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenzw
 */
public class SSHClient {

    private Session session;

    public void execCmd() throws JSchException, IOException {
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand("ls");
        channelExec.setErrStream(System.err);
        channelExec.connect();
        String result = IOUtils.toString(in, "UTF-8");
        channelExec.disconnect();
    }

}
