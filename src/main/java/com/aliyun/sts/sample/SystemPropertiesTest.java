package com.aliyun.sts.sample;

import java.io.IOException;

/**
 * Created by liujianhui on 17/2/17.
 */
public class SystemPropertiesTest {
    public static void main(String[] args) {
        System.setProperty("liujianhui", "liujianhui");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
