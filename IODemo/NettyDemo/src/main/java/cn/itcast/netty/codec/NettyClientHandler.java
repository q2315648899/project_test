package cn.itcast.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        BookMessage.Book  book=BookMessage.Book.newBuilder().setId(1).setName("Java从入门到精通").build();
        ctx.writeAndFlush(book);
    }

}

