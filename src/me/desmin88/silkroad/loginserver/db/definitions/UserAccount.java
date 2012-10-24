package me.desmin88.silkroad.loginserver.db.definitions;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/23/12
 * Time: 4:53 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class UserAccount {

    private String userName;
    private String passwordHash;
    private String salt;

    public UserAccount() {}

    public String getUserName() {
        return userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getSalt() {
        return salt;
    }
}
