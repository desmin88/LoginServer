package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.codec.GatewayInfoCodec;
import me.desmin88.silkroad.loginserver.net.codec.client.*;
import me.desmin88.silkroad.loginserver.net.codec.server.HandShakeCodec;
import me.desmin88.silkroad.loginserver.net.codec.server.PatchInfoCodec;
import me.desmin88.silkroad.loginserver.net.codec.server.ServerListCodec;

import java.util.HashMap;
import java.util.Map;

/**
 * Credit to SpoutServer + Vanilla, not created by me. To be replaced
 */
public class CodecLookupService {


    /**
     * A table which maps opcodes to codecs. This is generally used to map
     * incoming packets to a codec.
     */
    private static MessageCodec<?>[] opcodeTable = new MessageCodec<?>[65536];

    /**
     * A table which maps messages to codecs. This is generally used to map
     * outgoing packets to a codec.
     */
    private static Map<Class<? extends Message>, MessageCodec<?>> classTable = new HashMap<Class<? extends Message>, MessageCodec<?>>();

    /**
     * Populates the opcode and class tables with codecs.
     */

    static {
        try {
            /* 0x00 */
            bind(GatewayInfoCodec.class);

            bind(PatchInfoCodec.class);
            bind(HandShakeCodec.class);
            bind(ServerListCodec.class);
            // --client
            bind(AcceptHandShakeCodec.class);
            bind(AuthenticationCodec.class);
            bind(KeepAliveCodec.class);
            bind(RequestLauncherInfoCodec.class);
            bind(RequestPatchInfoCodec.class);
            bind(RequestServerListCodec.class);


        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static <T extends Message, C extends MessageCodec<T>> void bind(Class<C> clazz) throws InstantiationException, IllegalAccessException {
        MessageCodec<T> codec = clazz.newInstance();

        opcodeTable[codec.getOpcode()] = codec;
        classTable.put(codec.getType(), codec);
    }


    public static MessageCodec<?> find(int opcode) {
        if (opcode == -28672)
            return opcodeTable[0x9000];
        return opcodeTable[opcode];
    }


    public static <T extends Message> MessageCodec<T> find(Class<T> clazz) {
        return (MessageCodec<T>) classTable.get(clazz);
    }


}
