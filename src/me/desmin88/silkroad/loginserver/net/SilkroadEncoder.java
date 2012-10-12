package me.desmin88.silkroad.loginserver.net;

import com.sun.servicetag.SystemEnvironment;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:35 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadEncoder extends OneToOneEncoder {

    @SuppressWarnings("unchecked")
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel c, Object msg) throws Exception {
        if (msg instanceof Message) {
            Message message = (Message) msg;

            Class<? extends Message> clazz = message.getClass();
            MessageCodec<Message> codec = (MessageCodec<Message>) CodecLookupService.find(clazz);
            if (codec == null) {
                throw new IOException("Unknown message type: " + clazz + ".");
            }


            ChannelBuffer opcodeBuffer = ChannelBuffers.dynamicBuffer(3);
            opcodeBuffer.writeShort(codec.getOpcode());
            opcodeBuffer.writeShort(0);

            System.out.println("opCodeBuffer = " + Arrays.toString(opcodeBuffer.toByteBuffer().array()));
            System.out.println("Encoded handshake = " + Arrays.toString(codec.encode(message).toByteBuffer().array()));

            ChannelBuffer beforeLength = ChannelBuffers.wrappedBuffer(opcodeBuffer, codec.encode(message));
            int length = beforeLength.toByteBuffer().array().length - 4;
            System.out.println("length = " + length);
            ChannelBuffer lengthBuffer = ChannelBuffers.dynamicBuffer(3);
            lengthBuffer.writeShort(length);

            System.out.println("lenthBuffer = " + Arrays.toString(lengthBuffer.toByteBuffer().array()));
            ChannelBuffer finalBuffer = ChannelBuffers.wrappedBuffer(lengthBuffer, beforeLength);

            System.out.println(Arrays.toString(finalBuffer.toByteBuffer().array()));
            return finalBuffer;
        }
        return msg;
    }


}
