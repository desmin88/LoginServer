package me.desmin88.silkroad.loginserver.net.codec;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.utils.ChannelBufferUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 6:01 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class GatewayInfoCodec extends MessageCodec<GatewayInfoMessage> {

    public GatewayInfoCodec() {
        super(GatewayInfoMessage.class, 0x2001);
    }


    @Override
    public GatewayInfoMessage decode(ChannelBuffer buffer) throws IOException {
        //int nameLength = buffer.readShort(); Taken care of in buffer utils
        String name = ChannelBufferUtils.readUtf8String(buffer);
        byte flagTemp = buffer.readByte();
        boolean flag;
        flag = (flagTemp == 1) ? true : false;


        return new GatewayInfoMessage(name.length(), name, flag);
    }

    @Override
    public ChannelBuffer encode(GatewayInfoMessage message) throws IOException {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, 16);

        //buffer.writeShort(message.getNameLength());
        //buffer.writeBytes(message.getName().getBytes());
        ChannelBufferUtils.writeUtf8String(buffer, message.getName());
        if(message.getFlag())
            buffer.writeByte(1);
        else
            buffer.writeByte(0);

        return buffer;
    }

}
