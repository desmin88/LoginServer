package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestServerListMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:12 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestServerListCodec extends MessageCodec<RequestServerListMessage> {

    public RequestServerListCodec () {
        super(RequestServerListMessage.class, 0x6101);
    }


    @Override
    public RequestServerListMessage decode(ChannelBuffer buffer) throws IOException {
        return new RequestServerListMessage();
    }

    @Override
    public ChannelBuffer encode(RequestServerListMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }




}
