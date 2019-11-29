package com.netty.two_one;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;

public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        new EchoServer(8080).start();
    }
    //EchoServerHandler 实现了业务逻辑
    //main()方法引导了服务器
    //创建一个ServerBootstrap的实例以引导和绑定服务器
    //创建并分配一个NioEventLoopGroup实例进行事件的处理，如接受新连接以及读/写数据
    //指定服务器绑定本地的InetSocketAddress
    //使用一个EchoServerHandler的实例初始化每一个新的Channel
    //调用ServerBootstrap.bind()方法以绑定服务器
    public void start() throws Exception{
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            EventExecutorGroup executorGroup = new DefaultEventExecutorGroup(150);
            ServerBootstrap b = new ServerBootstrap();
            b.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception{
                            ch.pipeline().addLast(executorGroup,serverHandler);
                        }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
