package me.desmin88.silkroad.loginserver.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/21/12
 * Time: 5:01 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class HashUtils {

    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getHash(String password){
        try {
            messageDigest.update(password.getBytes("UTF-8"));
        } catch (Exception e) {}

        return new String(Hex.encodeHex(messageDigest.digest()));
    }
}
