package me.desmin88.silkroad.loginserver.net.codec.server;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.server.AuthenticationResponseMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/21/12
 * Time: 4:26 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AuthenticationResponseCodec extends MessageCodec<AuthenticationResponseMessage> {

    public AuthenticationResponseCodec() {
        super(AuthenticationResponseMessage.class, 0xA102);
    }


    public AuthenticationResponseMessage decode(ChannelBuffer buffer) throws IOException {
        // --Will never decode this packet
        return null;
    }

    @Override
    public ChannelBuffer encode(AuthenticationResponseMessage message) throws IOException {
        ChannelBuffer buffer = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, 1);
        if (message.encodingFlag == 0) {
            //TODO success
        }
        if (message.encodingFlag == 1) {
            //TODO already connected
        }
        if (message.encodingFlag == 2) {
            //TODO wronginfo
        }
        if (message.encodingFlag == 3) {
            //TODO banned
        }
        if (message.encodingFlag == 4) {
            //TODO serverfull
        }

        return buffer;
    }

}
