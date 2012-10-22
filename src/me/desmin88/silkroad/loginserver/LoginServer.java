package me.desmin88.silkroad.loginserver;

import me.desmin88.silkroad.loginserver.db.MongoHelper;
import me.desmin88.silkroad.loginserver.net.SessionRegistry;
import me.desmin88.silkroad.loginserver.net.SilkroadPipelineFactory;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:13 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class LoginServer {

    /**
     * The logger for this class
     */
    public static final Logger logger = Logger.getLogger(LoginServer.class.getName());

    /**
     * The {@link ServerBootstrap} used to initialize Netty.
     */
    private final ServerBootstrap bootstrap = new ServerBootstrap();

    /**
     * A group containing all of the channels.
     */
    private final ChannelGroup group = new DefaultChannelGroup();

    /**
     * The network executor service - Netty dispatches events to this thread
     * pool.
     */
    private final ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * The registry containing all of our sessions
     */
    private final SessionRegistry sessionRegistry = new SessionRegistry();


    /**
     * Main method for server startup
     */
    public static void main(String[] args) {
        try {
            LoginServer server = new LoginServer();
            server.bind(new InetSocketAddress(15779));
            server.start();
        } catch (Throwable t) {
            logger.log(Level.SEVERE, "Error during login server startup.", t);
        }
    }

    /**
     * Constructor for our server main
     */
    public LoginServer() {
        logger.info("LoginServer is starting up...");
        init();
    }

    /**
     * Initializes the server
     */
    private void init() {
        MongoHelper.init();
        ChannelFactory factory = new NioServerSocketChannelFactory(executor, executor);
        bootstrap.setFactory(factory);

        ChannelPipelineFactory pipelineFactory = new SilkroadPipelineFactory(this);
        bootstrap.setPipelineFactory(pipelineFactory);

        bootstrap.setOption("child.bufferFactory", new HeapChannelBufferFactory(ByteOrder.LITTLE_ENDIAN));
    }


    /**
     * Binds our server to the silkroad port
     */
    private void bind(SocketAddress port) {
        logger.info("Binding to address: " + port + "...");
        group.add(bootstrap.bind(port));
    }

    /**
     * Officially start the server
     */
    private void start() {
        logger.info("Ready for connections.");
    }

    /**
     * Allows us to get our channel group
     */
    public ChannelGroup getChannelGroup() {
        return group;
    }

    /**
     * Allows outside classes to access the session registry
     */
    public SessionRegistry getSessionRegistry() {
        return sessionRegistry;
    }
}
