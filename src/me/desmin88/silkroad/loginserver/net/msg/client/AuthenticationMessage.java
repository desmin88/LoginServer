package me.desmin88.silkroad.loginserver.net.msg.client;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/14/12
 * Time: 1:16 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AuthenticationMessage extends Message {

    private byte locale;
    private byte usernameLength;
    private String username;
    private byte passwordLength;
    private String password;
    private byte padding = 0x00;
    private byte gameServerID;
    private byte division; // div + 0x01

    public AuthenticationMessage(byte locale, byte usernameLength, String username, byte passwordLength, String password, byte padding, byte gameServerID, byte division) {
        this.locale = locale;
        this.usernameLength = usernameLength;
        this.username = username;
        this.passwordLength = passwordLength;
        this.password = password;
        this.padding = padding;
        this.gameServerID = gameServerID;
        this.division = division;
    }

    public byte getLocale() {
        return locale;
    }

    public byte getUsernameLength() {
        return usernameLength;
    }

    public String getUsername() {
        return username;
    }

    public byte getPasswordLength() {
        return passwordLength;
    }

    public String getPassword() {
        return password;
    }

    public byte getPadding() {
        return padding;
    }

    public byte getGameServerID() {
        return gameServerID;
    }

    public byte getDivision() {
        return division;
    }
}
