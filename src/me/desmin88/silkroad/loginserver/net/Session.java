package me.desmin88.silkroad.loginserver.net;

import com.mongodb.BasicDBObject;
import me.desmin88.silkroad.loginserver.db.MongoHelper;
import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.*;
import me.desmin88.silkroad.loginserver.net.msg.server.HandShakeMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.PatchInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.ServerListMessage;
import me.desmin88.silkroad.loginserver.utils.HashUtils;
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

    private int failedLogins = 0;

    public Session(Channel channel) {
        this.channel = channel;
        channel.write(new HandShakeMessage((byte) 0x01));
    }

    public void messageReceived(Message message) {

        if (message instanceof GatewayInfoMessage) {
            // RECEIVED: 0x2001, SEND: 0x2001
            String name = "GatewayServer";
            int length = name.length();
            boolean flag = true;
            GatewayInfoMessage toSend = new GatewayInfoMessage(length, name, flag);
            channel.write(toSend);
        }
        if (message instanceof RequestPatchInfoMessage) {
            // RECEIVED: 0x6100, SEND: 0xA100
            channel.write(new PatchInfoMessage());
        }
        if (message instanceof RequestServerListMessage) {
            // RECEIVED: 0x6101, SEND: 0xA101
            channel.write(new ServerListMessage());
        }

        if (message instanceof AuthenticationMessage) {
            // RECEIVED: 0x6102, SEND: 0xA102
            AuthenticationMessage authenticationMessage = (AuthenticationMessage) message;
            String username = authenticationMessage.getUsername();
            String password = authenticationMessage.getPassword();
            int serverID = authenticationMessage.getGameServerID();

            BasicDBObject query = new BasicDBObject();

            query.put("username", username);
            query.put("passwordHash", HashUtils.getHash(password));
            MongoHelper.getCollection().find(query).



        }

        if (message instanceof KeepAliveMessage || message instanceof AcceptHandShakeMessage || message instanceof RequestLauncherInfoMessage) {
            // 1. Ignore - Sent every 5 seconds with no data
            // 2. Ignore - Sent after 0x5000 with no data
            // 3. Ignore - Unknown Structure
        }


    }
}
