package me.desmin88.silkroad.loginserver.msg;

import me.desmin88.silkroad.loginserver.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 6:01 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class GatewayInfoMessage extends Message {

    private int nameLength = "GatewayServer".length();

    private String name = "GatewayServer";

    private boolean flag;

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
