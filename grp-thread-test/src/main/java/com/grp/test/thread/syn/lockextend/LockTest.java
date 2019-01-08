package com.grp.test.thread.syn.lockextend;

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
        ExtendTestObject extendTestObject = new ExtendTestObject("2");
        ThreadFive t3 = new ThreadFive("task 3",extendTestObject);
        ThreadFive t4 = new ThreadFive("task 4",extendTestObject);
        t3.start();
        t4.start();
        TempTestObject tempTestObject = new TempTestObject("2");
        ThreadSix t5 = new ThreadSix("task 5",tempTestObject);
        ThreadSix t6 = new ThreadSix("task 6",tempTestObject);
        t5.start();
        t6.start();
    }
}
