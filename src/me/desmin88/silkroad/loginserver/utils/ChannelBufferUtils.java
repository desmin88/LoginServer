package me.desmin88.silkroad.loginserver.utils;

import org.jboss.netty.buffer.ChannelBuffer;

import java.nio.charset.Charset;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 6:21 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class ChannelBufferUtils {

    private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    /**
     * Writes a string to the buffer.
     * @param buf The buffer.
     * @param str The string.
     * @throws IllegalArgumentException if the string is too long
     * <em>after</em> it is encoded.
     */
    public static void writeString(ChannelBuffer buf, String str) {
        int len = str.length();
        if (len >= 65536) {
            throw new IllegalArgumentException("String too long.");
        }

        buf.writeShort(len);
        for (int i = 0; i < len; i++) {
            buf.writeChar(str.charAt(i));
        }
    }

    /**
     * Writes a UTF-8 string to the buffer.
     * @param buf The buffer.
     * @param str The string.
     * @throws IllegalArgumentException if the string is too long
     * <em>after</em> it is encoded.
     */
    public static void writeUtf8String(ChannelBuffer buf, String str) {
        byte[] bytes = str.getBytes(CHARSET_UTF8);
        if (bytes.length >= 65536) {
            throw new IllegalArgumentException("Encoded UTF-8 string too long.");
        }

        buf.writeShort(bytes.length);
        buf.writeBytes(bytes);
    }

    /**
     * Reads a string from the buffer.
     * @param buf The buffer.
     * @return The string.
     */
    public static String readString(ChannelBuffer buf) {
        int len = buf.readUnsignedShort();

        char[] characters = new char[len];
        for (int i = 0; i < len; i++) {
            characters[i] = buf.readChar();
        }
        return new String(characters);
    }


    /**
     * Reads a UTF-8 encoded string from the buffer.
     * @param buf The buffer.
     * @return The string.
     */
    public static String readUtf8String(ChannelBuffer buf) {
        int len = buf.readUnsignedShort();

        byte[] bytes = new byte[len];
        buf.readBytes(bytes);

        return new String(bytes, CHARSET_UTF8);
    }


}