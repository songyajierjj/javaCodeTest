package com.netty.two_one;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf in = (ByteBuf)msg;
        System.out.println("server received:" + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);//讲接收到的消息写给发送者，而不冲刷出战消息
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        //将未决消息冲刷dao远程节点，并关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();//打印异常栈跟踪
        ctx.close();//关闭该Channel
    }
}

