package com.aliyun.sts.sample.java;

/**
 * Created by liujianhui on 17/4/29.
 */
public class B extends A {
    public void print() {
        hasLong(1L);
    }

    public static void main(String[] args) {
        B b = new B();
        b.print();;
    }
}
