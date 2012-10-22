package me.desmin88.silkroad.loginserver.net.codec.client;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestLauncherInfoMessage;
import org.jboss.netty.buffer.ChannelBuffer;

import java.io.IOException;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:08 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestLauncherInfoCodec extends MessageCodec<RequestLauncherInfoMessage> {

    public RequestLauncherInfoCodec() {
        super(RequestLauncherInfoMessage.class, 0x6104);
    }


    @Override
    public RequestLauncherInfoMessage decode(ChannelBuffer buffer) throws IOException {
        return new RequestLauncherInfoMessage();
    }

    @Override
    public ChannelBuffer encode(RequestLauncherInfoMessage message) throws IOException {
        // --Will never send this packet
        return null;
    }


}
