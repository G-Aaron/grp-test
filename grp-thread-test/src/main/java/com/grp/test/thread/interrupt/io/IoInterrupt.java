package com.grp.test.thread.interrupt.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * interrupt i/o阻塞
 */
public class IoInterrupt implements Runnable {
	public static void main(String[] args) throws Exception {
		IoInterrupt ioInterrupt = new IoInterrupt();
		Thread thread = new Thread(ioInterrupt);
		thread.start();
		Thread.sleep(800);
		thread.interrupt();
		System.out.println("interrupt state = " + thread.isInterrupted());
	}
 
	public void run() {
		try {
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
		}finally {
			System.out.println("线程即将结束 ： thread state:"+Thread.currentThread().getState()+" interrupt state = " + Thread.currentThread().isInterrupted());
		}
	}
}
