package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.AuthenticationMessage;
import me.desmin88.silkroad.loginserver.utils.ChannelBufferUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:20 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AuthenticationCodec extends MessageCodec<AuthenticationMessage> {

    public AuthenticationCodec() {
        super(AuthenticationMessage.class, 0x6002);
    }


    @Override
    public AuthenticationMessage decode(ChannelBuffer buffer) throws IOException {
        byte locale = buffer.readByte();
        String username = ChannelBufferUtils.readUtf8String(buffer);
        String password = ChannelBufferUtils.readUtf8String(buffer);;
        byte usernameLength = (byte) username.length();
        byte passwordLength = (byte) password.length();
        byte padding = buffer.readByte();
        byte gameServerID = buffer.readByte();
        byte division = buffer.readByte(); // div + 0x01
        return new AuthenticationMessage(locale, usernameLength, username, passwordLength, password, padding, gameServerID, division);
    }

    @Override
    public ChannelBuffer encode(AuthenticationMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }


}
