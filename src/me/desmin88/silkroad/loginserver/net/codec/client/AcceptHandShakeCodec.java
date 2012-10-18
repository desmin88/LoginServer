package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.AcceptHandShakeMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;


/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 12:48 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AcceptHandShakeCodec extends MessageCodec<AcceptHandShakeMessage> {

    public AcceptHandShakeCodec() {
        super(AcceptHandShakeMessage.class, 0x9000);
    }


    @Override
    public AcceptHandShakeMessage decode(ChannelBuffer buffer) throws IOException {
        return new AcceptHandShakeMessage();
    }

    @Override
    public ChannelBuffer encode(AcceptHandShakeMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }



}
