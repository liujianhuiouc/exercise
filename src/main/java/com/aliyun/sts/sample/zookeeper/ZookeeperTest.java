package com.aliyun.sts.sample.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by liujianhui on 17/2/21.
 */
public class ZookeeperTest {
    public static void main(String[] args) throws IOException {
        String zkSever = "localhost:2181";
        ZooKeeper zookeeper = new ZooKeeper(zkSever, 6000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        });
        System.in.read();
    }
}
