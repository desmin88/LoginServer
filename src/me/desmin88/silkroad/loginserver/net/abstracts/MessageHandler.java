package me.desmin88.silkroad.loginserver.net.abstracts;

import me.desmin88.silkroad.loginserver.net.Session;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/22/12
 * Time: 5:04 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public abstract class MessageHandler<T extends Message> {

    /*
     * Handles a incoming message
     */
    public void handle(Session session, T message) {

    }


}
