package com.grp.test.thread.syn.unlock;

/**
 * <p>Title: suspend 释放锁吗 不释放</p>
 * <p>Description: stop 抛异常？</p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-10 13:54
 **/
public class SuspendTest implements Runnable {
    private String value;
    public SuspendTest(String value){
        this.value = value;
    }
    public void run() {
        synchronized (value){
            try{
                System.out.println(value);
//                Thread.currentThread().stop();
                Thread.currentThread().suspend();
                System.out.println(value);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args) throws InterruptedException {
        String value = "111";
        Thread thread = new Thread(new SuspendTest(value));
        thread.start();
        Thread.sleep(2000);
        thread.resume();
    }
}
