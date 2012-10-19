package me.desmin88.silkroad.loginserver.net.codec.server;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.server.PatchInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.ServerListMessage;
import me.desmin88.silkroad.loginserver.utils.ChannelBufferUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/18/12
 * Time: 6:58 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class ServerListCodec extends MessageCodec<ServerListMessage> {

    public ServerListCodec() {
        super(ServerListMessage.class, 0xA101);
    }

    @Override
    public ServerListMessage decode(ChannelBuffer buffer) throws IOException {
        return null;
    }

    @Override
    public ChannelBuffer encode(ServerListMessage message) throws IOException {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, 1);

        buffer.writeByte(0x01);
        buffer.writeByte(18);
        ChannelBufferUtils.writeUtf8String(buffer, "SRO_Global_TestBed");

        buffer.writeByte(0x00);

        buffer.writeByte(0x01);
        buffer.writeByte(18);
        ChannelBufferUtils.writeUtf8String(buffer, "SRO_EMU");
        buffer.writeByte(0);
        buffer.writeByte(100);
        buffer.writeByte(0x01);

        buffer.writeByte(0x00);

        return buffer;
    }


}
