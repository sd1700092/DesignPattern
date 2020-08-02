package juejin_netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

public class NettyClient {
    public static void main(String[] args) {
        Bootstrap bootStrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        
        bootStrap.group(group)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) {
                    ch.pipeline().addLast(new StringEncoder());
                }
            });
        
        Channel channel = bootStrap.connect("127.0.0.1", 8000).channel();
        
        while (true) {
            channel.writeAndFlush(new Date() + ": hello world!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
