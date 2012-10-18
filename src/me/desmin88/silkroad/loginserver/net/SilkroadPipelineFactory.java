package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.LoginServer;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:33 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadPipelineFactory implements ChannelPipelineFactory {

    /**
     * The server.
     */
    private final LoginServer server;

    /**
     * Creates a new Silkroad pipeline factory.
     * @param server The server.
     */
    public SilkroadPipelineFactory(LoginServer server) {
        this.server = server;
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        return Channels.pipeline(new SilkroadPacketFrameDecoder(), new SilkroadEncoder(), new SilkroadHandler(server));
    }


}
