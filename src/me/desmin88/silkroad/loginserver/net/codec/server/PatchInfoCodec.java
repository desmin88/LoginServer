package me.desmin88.silkroad.loginserver.net.codec.server;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.server.PatchInfoMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:33 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class PatchInfoCodec extends MessageCodec<PatchInfoMessage> {

    public PatchInfoCodec() {
        super(PatchInfoMessage.class, 0xA100);
    }


    @Override
    public PatchInfoMessage decode(ChannelBuffer buffer) throws IOException {
        return new PatchInfoMessage();
    }

    @Override
    public ChannelBuffer encode(PatchInfoMessage message) throws IOException {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, 1);
        buffer.writeByte(0x01);
        return buffer;
    }



}
