package com.grp.test.thread.objectlock;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 15:32
 **/
public class T1 extends Thread {
    private String name;
    private TestObject object;
    public T1(String name, TestObject object) {
        this.name = name;
        this.object = object;
    }

    @Override
    public void run() {
        this.create(this.object);
    }

    public void create(TestObject object){
        synchronized(object){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
