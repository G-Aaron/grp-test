package com.grp.test.thread.objectlock;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:34
 **/
public class ObjectLockTest {
    public static void main(String[] args){
        TestObject object = new TestObject("1");
        TestObject object1 = new TestObject("1");
        ThreadOne t1 = new ThreadOne("task 1",object);
        ThreadOne t2 = new ThreadOne("task 2",object1);
        t1.start();
        t2.start();
    }
}
