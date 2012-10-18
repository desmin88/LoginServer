package me.desmin88.silkroad.loginserver.net.msg.client;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:07 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestLauncherInfoMessage extends Message {

    private byte locale;

    public RequestLauncherInfoMessage(byte Locale) {
        this.locale = Locale;
    }

    public byte getLocale() {
        return locale;
    }
}
