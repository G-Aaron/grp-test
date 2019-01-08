package com.grp.test.thread.syn.classlock;

import com.grp.test.thread.syn.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:32
 **/
public class ThreadTwo extends Thread {
    protected String name;
    protected TestObject object;
    public ThreadTwo(String name, TestObject object) {
        this.name = name;
        this.object = object;
    }

    @Override
    public void run() {
        this.create(this.object);
    }

    public void create(TestObject object){
        synchronized(ThreadTwo.class){
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
