package com.aliyun.sts.sample;

import java.io.PrintStream;

/**
 * Created by liujianhui on 17/2/15.
 */
public class SystemError {
    public static void main(String[] args) {
        PrintStream printStream = System.err;
        printStream.println("hello");
        System.exit(1);
    }
}
