package com.aliyun.sts.sample;

import org.apache.spark.deploy.SparkSubmit;

import java.util.Arrays;

/**
 * Created by liujianhui on 17/2/14.
 */
public class SparkSubmitTest {
    public static void main(String[] args) {
        String[] newArgs = new String[args.length + 2];
        System.arraycopy(args, 0, newArgs, 0, args.length);
        newArgs[newArgs.length - 2] = "--conf";
        newArgs[newArgs.length - 1] = "spark.launcher.listener=com.aliyun.sts.sample.DefaultLauncherBackendListener";
        SparkSubmit.main(args);
    }
}
