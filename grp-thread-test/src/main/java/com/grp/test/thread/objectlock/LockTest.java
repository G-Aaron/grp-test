package com.grp.test.thread.objectlock;

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
        TestObject object1 = new TestObject("1");
        T1 t1 = new T1("task 1",object);
        T1 t2 = new T1("task 2",object1);
        t1.start();
        t2.start();
    }
}
