package me.desmin88.silkroad.loginserver.net;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/16/12
 * Time: 5:38 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class MassiveMsgEncoder {

    private static ChannelBuffer patchInfo = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, 19);

    static {
        patchInfo.writeShort(5);
        patchInfo.writeShort(0x600D);
        patchInfo.writeShort(0);

        patchInfo.writeByte(0x01);
        patchInfo.writeShort(0x01);
        patchInfo.writeShort(0xA100);

        // -- Rest of the data
        patchInfo.writeShort(2);
        patchInfo.writeShort(0x600D);
        patchInfo.writeShort(0);

        patchInfo.writeByte(0);
        patchInfo.writeByte(0x01);

    }

    public static Object getPatchInfo() {
        return patchInfo.duplicate();
    }

}
