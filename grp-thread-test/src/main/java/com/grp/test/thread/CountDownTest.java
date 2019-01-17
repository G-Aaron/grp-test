package com.grp.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: 基于 {@link LockSupport#parkNanos(Object, long)}</p>
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-16 15:47
 **/
public class CountDownTest {

    private static CountDownLatch start = new CountDownLatch(1);

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hahahahahaha");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(new SleepRunner());
        Thread thread1 = new Thread(new SleepRunner());
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("你们运行吧");
        start.countDown();
    }
}
