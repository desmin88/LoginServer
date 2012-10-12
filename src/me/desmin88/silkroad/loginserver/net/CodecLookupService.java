package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.codec.GatewayInfoCodec;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.codec.HandShakeCodec;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:35 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class CodecLookupService {


    /**
     * A table which maps opcodes to codecs. This is generally used to map
     * incoming packets to a codec.
     */
    private static MessageCodec<?>[] opcodeTable = new MessageCodec<?>[25000];

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
            /* 0x00 */ bind(GatewayInfoCodec.class);
                       bind(HandShakeCodec.class);

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
        return opcodeTable[opcode];
    }

    /**
     * Finds a codec by message class.
     * @param <T> The type of message.
     * @param clazz The message class.
     * @return The codec, or {@code null} if it could not be found.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Message> MessageCodec<T> find(Class<T> clazz) {
        return (MessageCodec<T>) classTable.get(clazz);
    }



}
