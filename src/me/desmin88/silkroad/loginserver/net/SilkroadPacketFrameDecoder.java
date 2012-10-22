package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import java.io.IOException;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/18/12
 * Time: 5:09 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadPacketFrameDecoder extends FrameDecoder {

    private int previousOpcode = -1;

    protected Object decode(ChannelHandlerContext ctx, Channel ch, ChannelBuffer buf) throws Exception {
        short length = -1;
        short opcode = -1;
        short security = -1;

        if (buf.readableBytes() < 6) {
            // Length header + opcode + security not received
            return null;
        }

        buf.markReaderIndex();

        length = buf.readShort();
        opcode = buf.readShort();
        security = buf.readShort();

        if (buf.readableBytes() < length) {
            buf.resetReaderIndex();
            return null;
        }

        MessageCodec<?> codec = CodecLookupService.find(opcode);
        if (codec == null) {
            throw new IOException("Unknown op code: " + opcode + " (previous opcode: " + previousOpcode + ").");
        }

        System.out.println("DEBUG:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("DEBUG:receivedLength: " + length);
        System.out.println("DEBUG:receivedOPCode: " + opcode);
        System.out.println("DEBUG:receivedSecurity: " + security);
        System.out.println("DEBUG:Codec being used: " + codec.getClass().getSimpleName());
        System.out.println("DEBUG:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        this.previousOpcode = opcode;


        ChannelBuffer frame = buf.readBytes(length);
        return codec.decode(frame);

    }

}
