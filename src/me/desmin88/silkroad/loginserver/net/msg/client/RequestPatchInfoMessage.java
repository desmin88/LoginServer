package me.desmin88.silkroad.loginserver.net.msg.client;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 12:51 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class RequestPatchInfoMessage extends Message {

    private byte locale;
    private byte nameLength;
    private String clientName;
    private double clientVersion;

    public RequestPatchInfoMessage(byte locale, byte nameLength, String clientName, double clientVersion)  {
        this.locale = locale;
        this.nameLength = nameLength;
        this.clientName = clientName;
        this.clientVersion = clientVersion;
    }

    public byte getLocale() {
        return locale;
    }

    public byte getNameLength() {
        return nameLength;
    }

    public String getClientName() {
        return clientName;
    }

    public double getClientVersion() {
        return clientVersion;
    }
}
