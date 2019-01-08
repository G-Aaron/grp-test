package com.grp.test.thread.lockextend;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: 重写同步方法</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 16:50
 **/
public class ExtendTestObject extends TestObject {
    public ExtendTestObject(String name) {
        super(name);
    }
    @Override
    public void print(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

}
