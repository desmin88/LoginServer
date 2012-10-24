package me.desmin88.silkroad.loginserver.net.handler;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import me.desmin88.silkroad.loginserver.db.MongoHelper;
import me.desmin88.silkroad.loginserver.db.definitions.UserAccount;
import me.desmin88.silkroad.loginserver.net.Session;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageHandler;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.AuthenticationMessage;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:42 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AuthenticationHandler extends MessageHandler<AuthenticationMessage> {

    /**
     *  Server received 0x2001, respond with 0x2001
     * @param session The client session object
     * @param message The received message to handle
     */
    public void handle(Session session, AuthenticationMessage message)  {
        if (message instanceof AuthenticationMessage) {
            // RECEIVED: 0x6102, SEND: 0xA102
            AuthenticationMessage authenticationMessage = (AuthenticationMessage) message;
            String sentUsername = authenticationMessage.getUsername();
            String sentPassword = authenticationMessage.getPassword();
            int sentServerID = authenticationMessage.getGameServerID();

            BasicDBObject query = new BasicDBObject();

            query.put("username", sentUsername);

            DBObject response = MongoHelper.getCollection().findOne(query);
            if(response == null) {
                // Wrong info
                return;
            }

            UserAccount userAccount = MongoHelper.getGson().fromJson(response.toString(), UserAccount.class);

    }
}

}