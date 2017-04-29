package com.aliyun.sts.sample;

import org.apache.spark.SparkConf;
import org.apache.spark.launcher.LaunchBackendListener;


/**
 * Created by liujianhui on 17/2/14.
 */
public class DefaultLauncherBackendListener implements LaunchBackendListener{
    public void setState(org.apache.spark.launcher.SparkAppHandle.State state, SparkConf sparkConf) {
        System.out.println(state);
    }

    public void setAppId(String appId, SparkConf sparkConf) {
        System.out.println("------" + appId);
    }
}
