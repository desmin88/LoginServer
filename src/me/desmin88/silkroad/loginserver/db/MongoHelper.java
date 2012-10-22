package me.desmin88.silkroad.loginserver.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/21/12
 * Time: 4:29 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class MongoHelper {

    public static final Logger logger = Logger.getLogger(MongoHelper.class.getName());

    private static Mongo mongo;

    private static DB database;

    private static DBCollection dbCollection;

    public static void init() {
        logger.info("Initializing MongoDB...");

        try {
            mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException e) {
            logger.log(Level.SEVERE, "Error initializing MongoDB connection.");
            e.printStackTrace();
        }

        database = mongo.getDB("SilkroadDB");
        mongo.setWriteConcern(WriteConcern.SAFE);
        database.getCollection("userInfo");

        logger.info("MongoDB Initialization complete...");
    }


    public static DBCollection getCollection() {
        return dbCollection;
    }







}
