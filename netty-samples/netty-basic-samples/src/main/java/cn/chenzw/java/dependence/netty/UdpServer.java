package cn.chenzw.java.dependence.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * 服务端
 */
public class UdpServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new UdpServerHandler());

        bootstrap
                // 监听2555端口
                .bind(2555)
                .sync()
                .channel()
                .closeFuture()
                .await();
    }

    /**
     * 业务处理类
     */
    public static class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        private Logger logger = LoggerFactory.getLogger(getClass());

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
            // 接收数据
            ByteBuf buf = datagramPacket.copy().content();
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, StandardCharsets.UTF_8);
            logger.info("Server receive: {}", body);

            // 发送数据
            String sendData = "Ok, I had receive data!";
            DatagramPacket sendDatagramPacket = new DatagramPacket(Unpooled.copiedBuffer(sendData.getBytes()), datagramPacket.sender());
            channelHandlerContext.writeAndFlush(sendDatagramPacket);
            logger.info("Server send: {}", sendData);
        }
    }

}
