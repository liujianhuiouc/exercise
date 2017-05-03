package com.aliyun.sts.sample.proto;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by liujianhui on 17/5/3.
 */
public class MobieTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Mobile.MobilePhone.Builder builder = Mobile.MobilePhone.newBuilder();
        Mobile.Hardware.Builder hardware = Mobile.Hardware.newBuilder();
        hardware.setRam(2).setRom(16).setSize(5);
        builder.setHardware(hardware)
                .setBrand("Apple")
                .addSoftware("camera")
                .addSoftware("tecent")
                .addSoftware("browser")
                .addSoftware("player");
        byte[] messageBody = builder.build().toByteArray();

        int headerLen = 1;
        byte[] message = new byte[headerLen+messageBody.length];
        message[0] = (byte)messageBody.length;
        System.arraycopy(messageBody, 0,  message, 1, messageBody.length);
        System.out.println("msg len:"+message.length);

        Mobile.MobilePhone phone = Mobile.MobilePhone.parseFrom(messageBody);
        System.out.println("Receive:");
        System.out.println(phone.toString());
    }
}
