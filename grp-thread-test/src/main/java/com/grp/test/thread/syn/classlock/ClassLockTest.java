package com.grp.test.thread.syn.classlock;

import com.grp.test.thread.syn.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:34
 **/
public class ClassLockTest {
    public static void main(String[] args){
        TestObject object = new TestObject("1");
        TestObject object1 = new TestObject("1");
        ThreadTwo t1 = new ThreadTwo("task 1",object);
        ThreadTwo t2 = new ThreadTwo("task 2",object1);
        t1.start();
        t2.start();
    }
}
