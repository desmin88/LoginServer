package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestPatchInfoMessage;
import me.desmin88.silkroad.loginserver.utils.ChannelBufferUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:01 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestPatchInfoCodec extends MessageCodec<RequestPatchInfoMessage> {

    public RequestPatchInfoCodec() {
        super(RequestPatchInfoMessage.class, 0x6100);
    }


    @Override
    public RequestPatchInfoMessage decode(ChannelBuffer buffer) throws IOException {
        byte locale = buffer.readByte();
        String clientName = ChannelBufferUtils.readUtf8String(buffer);
        int clientVersion = buffer.readInt();
        return new RequestPatchInfoMessage(locale, (byte) clientName.length(), clientName, clientVersion);
    }

    @Override
    public ChannelBuffer encode(RequestPatchInfoMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }





}
