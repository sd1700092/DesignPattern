package com.imooc.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 初始化连接时候的各个组件
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        socketChannel.pipeline().addLast("http-codec", new HttpServerCodec());
//        socketChannel.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
//        socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        socketChannel.pipeline().addLast("handler", new MyWebSocketChannelHandler());
    }
}
