package com.grp.test.thread.interrupt.sleep;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * interrupt i/o阻塞
 */
@Slf4j
public class AfterSleepInterrupt implements Runnable {
	public static void main(String[] args) throws Exception {
		AfterSleepInterrupt ioInterrupt = new AfterSleepInterrupt();
		Thread thread = new Thread(ioInterrupt);
		thread.start();
		Thread.sleep(6000);
		thread.interrupt();
		log.info("让你睡个够 interrupt state = " + thread.isInterrupted());
	}
 
	public void run() {
		try {
			log.info("工作先放一放，睡一会 interrupt state = " + Thread.currentThread().isInterrupted());
			Thread.sleep(10000);
			log.info("睡醒工作");
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(4488));
			while (true) {
				// 阻塞一下
				serverSocketChannel.accept();
			}
		} catch (IOException e) {
			log.error("谁袭击我 interrupt state = {}\n ", Thread.currentThread().isInterrupted(), e);
		} catch (InterruptedException e) {
			log.error("我要报仇 interrupt state = {}\n ", Thread.currentThread().isInterrupted(), e);
		} finally {
			log.info("工作结束 ： thread state:"+Thread.currentThread().getState()+" interrupt state = " + Thread.currentThread().isInterrupted());
		}
	}
}
