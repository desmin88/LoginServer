package me.desmin88.silkroad.loginserver.net.msg.server;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/18/12
 * Time: 6:42 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class ServerListMessage extends Message {

    // NameServer: Start
    public byte nameServerFlag = 0x01;

    public byte nameServerID = 18;

    public byte nameLength = 0;

    public String name ="SRO_Global_TestBed";

    //NameServer: End

    public byte endFlag = 0x00;

    // GameServer: Start

    public byte gameServerFlag = 0x01;

    public byte gameServerID = 47;

    public byte gameLength = 0;

    public String game = "O_Emu";

    public byte currentUsers = 0;

    public int maxUsers = 1000;

    public byte inCheck = 0x00;

    // GameServer: End

    public byte endFlagAgain = 0x00;

    public ServerListMessage(byte nameServerFlag, byte nameServerID, byte nameLength, String name, byte endFlag, byte gameServerFlag, byte gameServerID, byte gameLength, String game, byte currentUsers, int maxUsers, byte inCheck, byte endFlagAgain) {
        this.nameServerFlag = nameServerFlag;
        this.nameServerID = nameServerID;
        this.nameLength = nameLength;
        this.name = name;
        this.endFlag = endFlag;
        this.gameServerFlag = gameServerFlag;
        this.gameServerID = gameServerID;
        this.gameLength = gameLength;
        this.game = game;
        this.currentUsers = currentUsers;
        this.maxUsers = maxUsers;
        this.inCheck = inCheck;
        this.endFlagAgain = endFlagAgain;
    }

    public ServerListMessage() {

    }

}
