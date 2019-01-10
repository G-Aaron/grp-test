package com.grp.test.thread.interrupt.sleep;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * interrupt i/o阻塞
 */
@Slf4j
public class BeforeSleepInterrupt implements Runnable {
	public static void main(String[] args) throws Exception {
		BeforeSleepInterrupt ioInterrupt = new BeforeSleepInterrupt();
		Thread thread = new Thread(ioInterrupt);
		thread.start();
		synchronized (thread){
			thread.interrupt();
            log.info("让你睡个够 interrupt state = " + thread.isInterrupted());
		}
	}
 
	public void run() {
		try {
            log.info("有人害我吗 interrupt state = " + Thread.currentThread().isInterrupted());
            log.info("工作先放一放，睡一会");
			Thread.sleep(1000);
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(4488));
            log.info("管道建立好了");
			while (true) {
				// 阻塞一下
				serverSocketChannel.accept();
			}
		} catch (IOException e) {
            log.info("工作掉链子了 interrupt state = " + Thread.currentThread().isInterrupted()+"\n "+e);
		} catch (InterruptedException e) {
            log.info("我要报仇 interrupt state = " + Thread.currentThread().isInterrupted()+"\n "+e);
		} finally {
            log.info("工作即将结束 ： thread state:"+Thread.currentThread().getState()+" interrupt state = " + Thread.currentThread().isInterrupted());
		}
	}
}
