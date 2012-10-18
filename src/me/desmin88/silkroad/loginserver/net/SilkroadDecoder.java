package me.desmin88.silkroad.loginserver.net;

import me.desmin88.silkroad.loginserver.net.abstracts.MessageCodec;
import me.desmin88.silkroad.loginserver.net.msg.GatewayInfoMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

import java.io.IOException;


/**
 * Created by William Ryan
 * User: Billy
 * Date: 10/9/12
 * Time: 5:35 PM
 * Not to be distributed, modified, or repackaged at all.
 */
public class SilkroadDecoder extends ReplayingDecoder<VoidEnum>{

    private int previousOpcode = -1;

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel c, ChannelBuffer buf, VoidEnum state) throws Exception {
        short length = -1;
        short opcode = -1;
        short security = -1;

//        //For some reason were getting trailing zeros or negative numbers.. idk
//        while((data = buf.readShort()) != -1 && data <= 0)  {
//            System.out.println("reading data" + data);
//            ;
//        }

        while(buf.readableBytes() != 0 ){
            length = buf.readShort();
            opcode = buf.readShort();
            security = buf.readShort();
        }

//        if(length == 0x6104) {
//            short test;
//            while((test = buf.readShort()) != -1)
//                System.out.println("reading more more data: " + test);
//
//        }

        System.out.println("---------------------------------------");
        System.out.println("receivedLength: " + length);
        System.out.println("receivedOPCode: " + opcode);
        System.out.println("receivedSecurity: " + security);
        System.out.println("---------------------------------------");

        MessageCodec<?> codec = CodecLookupService.find(opcode);
        if (codec == null) {
            throw new IOException("Unknown op code: " + opcode + " (previous opcode: " + previousOpcode + ").");
        }


        previousOpcode = opcode;


        return codec.decode(buf);
    }



}
