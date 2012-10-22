package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.KeepAliveMessage;
import org.jboss.netty.buffer.ChannelBuffer;

import java.io.IOException;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 12:42 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class KeepAliveCodec extends MessageCodec<KeepAliveMessage> {

    public KeepAliveCodec() {
        super(KeepAliveMessage.class, 0x2002);
    }


    @Override
    public KeepAliveMessage decode(ChannelBuffer buffer) throws IOException {
        return new KeepAliveMessage();
    }

    @Override
    public ChannelBuffer encode(KeepAliveMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }


}
