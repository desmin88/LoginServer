package me.desmin88.silkroad.loginserver.net.codec;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.HandShakeMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/11/12
 * Time: 4:52 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class HandShakeCodec extends MessageCodec<HandShakeMessage> {

    public HandShakeCodec() {
        super(HandShakeMessage.class, 0x5000);
    }



    public HandShakeMessage decode(ChannelBuffer buffer) throws IOException {
        byte handShake = buffer.readByte();
        return new HandShakeMessage(handShake);
    }

    @Override
    public ChannelBuffer encode(HandShakeMessage message) throws IOException {
        ChannelBuffer buffer = ChannelBuffers.buffer(1);
        buffer.writeByte(message.getHandShake());
        return buffer;
    }



}
