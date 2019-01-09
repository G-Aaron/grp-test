package com.grp.test.thread.interrupt.sleep;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * interrupt i/o阻塞
 */
public class SleepInterrupt implements Runnable {
	public static void main(String[] args) throws Exception {
		SleepInterrupt ioInterrupt = new SleepInterrupt();
		Thread thread = new Thread(ioInterrupt);
		thread.start();
		Thread.sleep(10000);
		thread.interrupt();
		System.out.println("interrupt state = " + thread.isInterrupted());
	}
 
	public void run() {
		try {
			Thread.sleep(10000L);
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(4488));
			System.out.println("建立好了");
			while (true) {
				// 阻塞一下
				serverSocketChannel.accept();
			}
		} catch (IOException e) {
			System.out.println("抛异常了 interrupt state = " + Thread.currentThread().isInterrupted()+"\n异常信息："+e);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程即将结束 ： thread state:"+Thread.currentThread().getState()+" interrupt state = " + Thread.currentThread().isInterrupted());
		}
	}
}
