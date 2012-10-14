package me.desmin88.silkroad.loginserver.net.msg;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 6:01 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class GatewayInfoMessage extends Message {

    private int nameLength = 0; // Possible values [9, 13]

    private String name = "";  // Possible values [SR_Client, GatewayServer]

    private boolean flag; // Possible values [0x00, 0x01]

    public GatewayInfoMessage(int nameLength, String name, boolean flag) {
        this.nameLength = nameLength;
        this.name = name;
        this.flag = flag;
    }

    public int getNameLength() {
        return nameLength;
    }

    public String getName() {
        return name;
    }

    public boolean getFlag() {
        return flag;
    }


}
