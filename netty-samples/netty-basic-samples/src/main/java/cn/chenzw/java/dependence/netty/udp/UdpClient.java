package cn.chenzw.java.dependence.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * 客户端
 */
public class UdpClient {

    private static Logger logger = LoggerFactory.getLogger(UdpClient.class);


    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .handler(new ClientHandler());

        String sendData = "Hello, Tom!";
        Channel channel = bootstrap.bind(0).sync().channel();
        channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(sendData, StandardCharsets.UTF_8), new InetSocketAddress("127.0.0.1", 2555)))
                .sync();
        logger.info("Client send: {}", sendData);

    }

    public static class ClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        private Logger logger = LoggerFactory.getLogger(getClass());

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
            String body = datagramPacket.content().toString(StandardCharsets.UTF_8);

            logger.info("Client receive: {}", body);
        }
    }
}
