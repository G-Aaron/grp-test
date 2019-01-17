package com.grp.test.thread.syn.unlock;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>Title: park 不释放锁</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-10 14:36
 **/
public class ParkTest implements Runnable{
    private String value;
    public ParkTest(String value){
        this.value = value;
    }
    @Override
    public void run() {

        while (true){
            synchronized (value){
                System.out.println("111");
                LockSupport.park( );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String value = "112";
        Thread thread = new Thread(new ParkTest(value));
        thread.start();
        Thread.sleep(3000);
        while (true){
            synchronized (value){
                System.out.println("222");
                LockSupport.unpark(thread);
            }
        }
    }
}
