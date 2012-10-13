package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.LoginServer;
import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import org.jboss.netty.channel.*;

import java.util.logging.Level;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:35 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadHandler extends SimpleChannelUpstreamHandler {

    /**
     * The server.
     */
    private final LoginServer server;

    /**
     * Creates a new network event handler.
     * @param server The server.
     */
    public SilkroadHandler(LoginServer server) {
        this.server = server;
    }
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        Channel c = e.getChannel();
        server.getChannelGroup().add(c);

        Session session = new Session(c);
        server.getSessionRegistry().add(session);
        ctx.setAttachment(session);

        System.out.println("Channel connected: " + c + ".");

    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        Channel c = e.getChannel();
        server.getChannelGroup().remove(c);

        Session session = (Session) ctx.getAttachment();
        server.getSessionRegistry().remove(session);

        System.out.println("Channel disconnected: " + c + ".");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        Session session = (Session) ctx.getAttachment();
        session.messageReceived((Message) e.getMessage());
        System.out.println("Message received in handler");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        Channel c = e.getChannel();
        if (c.isOpen()) {
            LoginServer.logger.log(Level.WARNING, "Exception caught, closing channel: " + c + "...", e.getCause());
            c.close();
        }
    }


}
