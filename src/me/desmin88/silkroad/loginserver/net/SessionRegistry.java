package me.desmin88.silkroad.loginserver.net;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/11/12
 * Time: 11:15 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SessionRegistry {

     /**
      * A list of all the maintained launcher connections
      */
     private final ConcurrentMap<Session, Boolean> sessions = new ConcurrentHashMap<Session, Boolean>();

    /**
     * Adds a new launcher session.
     * @param session The session to add.
     */
    public void add(Session session) {
        sessions.put(session, true);

    }

    /**
     * Removes a launcher session.
     * @param session The session to remove.
     */
    public void remove(Session session) {
        sessions.remove(session);
    }
}


