package me.desmin88.silkroad.loginserver.net.msg.server;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/21/12
 * Time: 4:02 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class AuthenticationResponseMessage extends Message {

    public int encodingFlag;

    public byte responseFlag; // 0x01 = success, 0x02 = failure

    // --Success
    public short gameServerID;

    public int ipLength;

    public String ipAddress;

    public short port;

    // --Success

    // --Error: Already Connected
    public byte alreadyConnected = 0x03;
    // --Error: Already Connected

    // --Error: WrongInfo
    public byte wrongInfo = 0x01;
    public byte maxFailedLogins = 5;
    public byte currentFailedLogins = 0;
    // --Error: AWrongInfo

    // --Error: ServerFull
    public byte full = 0x04;
    // --Error: ServerFull

    // --Error: UserBanned
    public byte banned = 0x02;
    public byte pad = 0x01;
    public int reasonLength;
    public String banReason;
    public byte nodate = 0x00;
    // --Error: UserBanned


}
