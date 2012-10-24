package me.desmin88.silkroad.loginserver.net.handler;

import me.desmin88.silkroad.loginserver.net.Session;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageHandler;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestPatchInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestServerListMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.ServerListMessage;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:32 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class ServerListHandler extends MessageHandler<RequestServerListMessage> {

    /**
     *  Server received 0x6101, respond with 0xA102
     * @param session The client session object
     * @param message The received message to handle
     */
    public void handle(Session session, RequestServerListMessage message)  {
        session.getChannel().write(new ServerListMessage());
    }


}
