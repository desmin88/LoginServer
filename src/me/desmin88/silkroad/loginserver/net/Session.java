package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.*;
import me.desmin88.silkroad.loginserver.net.msg.server.HandShakeMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.PatchInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.ServerListMessage;
import org.jboss.netty.channel.Channel;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/11/12
 * Time: 11:15 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class Session {

    private Channel channel = null;

    public Session(Channel channel) {
        this.channel = channel;
        channel.write(new HandShakeMessage((byte) 0x01));
    }

    public void messageReceived(Message message) {
        //TODO protocol implementation
        if (message instanceof GatewayInfoMessage) {
            // Requesting gateway info, send them the correct packet.
            String name = "GatewayServer";
            int length = name.length();
            boolean flag = true;
            GatewayInfoMessage toSend = new GatewayInfoMessage(length, name, flag);
            channel.write(toSend);
        }
        else if (message instanceof RequestPatchInfoMessage) {
            channel.write(new PatchInfoMessage());
        }

        else if (message instanceof RequestServerListMessage) {
            channel.write(new ServerListMessage());
        }

        else if (message instanceof AuthenticationMessage) {
            //TODO authentication

        }

        else if (message instanceof KeepAliveMessage) {
            // Ignore - Sent every 5 seconds with no data
        } else if (message instanceof AcceptHandShakeMessage) {
            // Ignore - Sent after 0x5000 with no data
        } else if (message instanceof RequestLauncherInfoMessage) {
            // Ignore - Unknown Structure
        }


    }
}
