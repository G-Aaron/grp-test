package com.grp.test.thread.lockextend;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 16:50
 **/
public class TempTestObject extends TestObject {
    public TempTestObject(String name) {
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
