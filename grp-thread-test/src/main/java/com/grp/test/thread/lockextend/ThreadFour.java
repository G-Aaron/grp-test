package com.grp.test.thread.lockextend;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:32
 **/
public class ThreadFour extends Thread {
    protected String name;
    protected TestObject object;
    public ThreadFour(String name, TestObject object) {
        this.name = name;
        this.object = object;
    }

    @Override
    public void run() {
        this.object.print();
    }

    public void create(TestObject object){
        synchronized(ThreadFour.class){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    synchronized public static void create(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

     synchronized public void print(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

}
