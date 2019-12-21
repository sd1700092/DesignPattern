package nettyinaction.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
    private String host;
    
    private int port;
    
    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // #1 Create bootstrap for client
            b.group(group) // #2 Specify EventLoopGroup to handle client events. NioEventLoopGroup is used, as the NIO-Transport            should be used
                .channel(NioSocketChannel.class) // #3 Specify channel type; use correct one for NIO-Transport
                .remoteAddress(new InetSocketAddress(this.host, this.port)) // #4 Set InetSocketAddress to which client connects
                .handler(new ChannelInitializer<SocketChannel>() { // #5 Specify ChannelHandler, using ChannelInitializer, called once connection established and channel created
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoClientHandler()); // #6 Add EchoClientHandler to ChannelPipeline that belongs to channel. ChannelPipeline holds all ChannelHandlers of channel
                }
            });
            ChannelFuture f = b.connect().sync(); // #7 Connect client to remote peer; wait until sync() completes connect completes
            f.channel().closeFuture().sync(); // #8 Wait until ClientChannel closes. This will block.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync(); // #9 Shut down bootstrap and thread pools; release all resources
        }
    }
    
    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1", 8888).start();
    }
}
