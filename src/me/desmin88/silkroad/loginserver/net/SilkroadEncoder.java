package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.Message;
import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:35 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadEncoder extends OneToOneEncoder {

    @SuppressWarnings("unchecked")
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel c, Object msg) throws Exception {
        if (msg instanceof Message) {

            Message message = (Message) msg;

            Class<? extends Message> clazz = message.getClass();
            MessageCodec<Message> codec = (MessageCodec<Message>) CodecLookupService.find(clazz);
            if (codec == null) {
                throw new IOException("Unknown message type: " + clazz + ".");
            }

            int opCode = codec.getOpcode();

            if (opCode == 0xA100) {
                return MassiveMsgEncoder.getPatchInfo();
            }

            // START: OPCODE BUFFER (TYPE: LITTLE-ENDIAN)
            ChannelBuffer opcodeBuffer = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, 4);
            opcodeBuffer.writeShort(opCode);
            opcodeBuffer.writeShort(0);
            // END: OPCODE BUFFER


            // START: ENCODE MESSAGE (TYPE: LITTLE-ENDIAN)
            ChannelBuffer encodedMessage = codec.encode(message);
            // END: ENCODE MESSAGE

            int length = (opcodeBuffer.array().length + encodedMessage.array().length) - 4;

            // START: LENGTH BUFFER (TYPE: LITTLE-ENDIAN) (Length of the packet must be affixed to the beginning, minus the length of the length buffer)
            ChannelBuffer lengthBuffer = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, 2);
            lengthBuffer.writeShort(length);
            // END: LENGTH BUFFER

            ChannelBuffer finalBuffer = ChannelBuffers.wrappedBuffer(lengthBuffer, opcodeBuffer, encodedMessage);


//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//            System.out.println("opCode = "+  codec.getOpcode());
//            System.out.println("opCodeBuffer = " + Arrays.toString(opcodeBuffer.toByteBuffer().array()));
//            System.out.println("Encoded handshake = " + Arrays.toString(codec.encode(message).toByteBuffer().array()));
//            System.out.println("length = " + length);
//            System.out.println("lengthBuffer = " + Arrays.toString(lengthBuffer.toByteBuffer().array()));
//            System.out.println(Arrays.toString(finalBuffer.toByteBuffer().array()));
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


            return finalBuffer;
        }
        return msg;
    }


}