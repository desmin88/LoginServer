package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageHandler;
import me.desmin88.silkroad.loginserver.net.handler.AuthenticationHandler;
import me.desmin88.silkroad.loginserver.net.handler.GatewayInfoHandler;
import me.desmin88.silkroad.loginserver.net.handler.RequestPatchInfoHandler;
import me.desmin88.silkroad.loginserver.net.handler.ServerListHandler;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.AuthenticationMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestPatchInfoMessage;
import me.desmin88.silkroad.loginserver.net.msg.client.RequestServerListMessage;
import me.desmin88.silkroad.loginserver.net.msg.server.ServerListMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:23 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class HandlerLookupService {

    protected static final Map<Class<? extends Message>, MessageHandler<?>> handlers = new HashMap<Class<? extends Message>, MessageHandler<?>>();

    protected static <T extends Message> void bind(Class<T> clazz, Class<? extends MessageHandler<T>> handlerClass) throws InstantiationException, IllegalAccessException {
        MessageHandler<T> handler = handlerClass.newInstance();
        handlers.put(clazz, handler);
    }

    protected static <T extends Message> void bind(Class<T> clazz, MessageHandler<T> handler) throws InstantiationException, IllegalAccessException {
        handlers.put(clazz, handler);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Message> MessageHandler<T> find(Class<T> clazz) {
        return (MessageHandler<T>) handlers.get(clazz);
    }

    protected HandlerLookupService() {
    }

    static
    {
        try
        {
            bind(GatewayInfoMessage.class, GatewayInfoHandler.class);
            bind(RequestPatchInfoMessage.class, RequestPatchInfoHandler.class);
            bind(RequestServerListMessage.class, ServerListHandler.class);
            bind(AuthenticationMessage.class, AuthenticationHandler.class);
        }   catch(Exception e) {
                e.printStackTrace();
        }
    }





}
