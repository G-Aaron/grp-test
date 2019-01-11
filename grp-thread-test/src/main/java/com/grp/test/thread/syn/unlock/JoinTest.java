package com.grp.test.thread.syn.unlock;

/**
 * <p>Title: join 释放锁吗 不释放</p>
 * <p>Description: 只是放 调用线程 的同步锁</p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-10 13:54
 **/
public class JoinTest implements Runnable {
    private String value;
    public JoinTest(String value){
        this.value = value;
    }
    @Override
    public void run() {
        final Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("222");
                synchronized (value){
                    System.out.println("3333");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        synchronized (value){
            System.out.println(value);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(value);
        }
    }
    public static void main(String [] args) throws InterruptedException {
        String value = "111";
        Thread thread = new Thread(new JoinTest(value));
        thread.start();
    }
}
