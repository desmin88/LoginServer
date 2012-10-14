package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
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
    }

   public void messageReceived(Message message) {
       System.out.println("Message received in session");
       //TODO protocol implementation
        if(message instanceof HandShakeMessage) {
            // Not possible
        }
        else if(message instanceof GatewayInfoMessage) {
            // Requesting gateway info, send them the correct packet.
            String name = "GatewayServer";
            int length  = name.length();
            boolean flag = true;
            GatewayInfoMessage toSend = new GatewayInfoMessage(length, name, flag);
            channel.write(toSend);

        }


       System.out.println("Message received in session");
   }


}
