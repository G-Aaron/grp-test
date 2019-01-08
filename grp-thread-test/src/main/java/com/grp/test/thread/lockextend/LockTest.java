package com.grp.test.thread.lockextend;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:34
 **/
public class LockTest {
    public static void main(String[] args){
        TestObject object = new TestObject("1");
        ThreadTree t1 = new ThreadTree("task 1",object);
        ThreadTree t2 = new ThreadTree("task 2",object);
        t1.start();
        t2.start();
        ExtendTestObject extendTestObject = new ExtendTestObject("2");
        ThreadFive t3 = new ThreadFive("task 3",extendTestObject);
        ThreadFive t4 = new ThreadFive("task 4",extendTestObject);
        t3.start();
        t4.start();
    }
}
