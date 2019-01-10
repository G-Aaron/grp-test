package com.grp.test.thread.syn.unlock;

/**
 * <p>Title: wait 释放锁吗 放</p>
 * <p>Description: wait notice 只能在同步代码中使用？</p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-10 13:42
 **/
public class WaitSynTest implements Runnable{

    private String value;

    public WaitSynTest(String value){
        this.value = value;
    }
    public void run() {
        synchronized (value){
            try {
                System.out.println("1 "+value);
                value.wait(10000);
                System.out.println("3 "+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String value = "111";
        Thread thread = new Thread(new WaitSynTest(value));
        thread.start();
        Thread.sleep(1000);
        synchronized (value){
            System.out.println("2 "+value);
            value.notify();
        }

    }
}
