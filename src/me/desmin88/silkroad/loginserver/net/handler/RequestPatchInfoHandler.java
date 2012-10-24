package me.desmin88.silkroad.loginserver.net.handler;

import me.desmin88.silkroad.loginserver.net.Session;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageHandler;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestPatchInfoMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:29 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestPatchInfoHandler extends MessageHandler<RequestPatchInfoMessage> {

    /**
     *  Server received 0x6100, respond with 0xA100
     * @param session The client session object
     * @param message The received message to handle
     */
    public void handle(Session session, RequestPatchInfoMessage message)  {
        ChannelBuffer patchInfo = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, 19);

        patchInfo.writeShort(5);
        patchInfo.writeShort(0x600D);
        patchInfo.writeShort(0);

        patchInfo.writeByte(0x01);
        patchInfo.writeShort(0x01);
        patchInfo.writeShort(0xA100);

        // -- Rest of the data
        patchInfo.writeShort(2);
        patchInfo.writeShort(0x600D);
        patchInfo.writeShort(0);

        patchInfo.writeByte(0);
        patchInfo.writeByte(0x01);

        session.getChannel().write(patchInfo);

    }

}



