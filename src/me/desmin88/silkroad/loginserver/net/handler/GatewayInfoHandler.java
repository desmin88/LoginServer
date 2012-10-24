package me.desmin88.silkroad.loginserver.net.handler;

import me.desmin88.silkroad.loginserver.net.Session;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageHandler;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:08 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class GatewayInfoHandler extends MessageHandler<GatewayInfoMessage> {

    /**
     *  Server received 0x2001, respond with 0x2001
     * @param session The client session object
     * @param message The received message to handle
     */
    public void handle(Session session, GatewayInfoMessage message)  {
        if(message.getName().equals("SR_Client")){
            String serverName = "GatewayServer";
            int nameLength = serverName.length();
            boolean serverFlag = true;
            GatewayInfoMessage gatewayInfoMessage = new GatewayInfoMessage(nameLength, serverName, serverFlag);
            session.getChannel().write(gatewayInfoMessage);
        }

    }

}
