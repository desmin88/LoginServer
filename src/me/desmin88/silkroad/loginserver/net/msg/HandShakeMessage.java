package me.desmin88.silkroad.loginserver.net.msg;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/11/12
 * Time: 3:39 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class HandShakeMessage extends Message {

       private byte HandShake = 0x01;

       public HandShakeMessage(byte handShake) {
           this.HandShake = handShake;
       }

    public byte getHandShake() {
        return HandShake;
    }
}
