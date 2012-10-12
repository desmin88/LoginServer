package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.msg.HandShakeMessage;
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
        //TODO send handshake
    }

   public void messageReceived(Message message) {

   }


}
