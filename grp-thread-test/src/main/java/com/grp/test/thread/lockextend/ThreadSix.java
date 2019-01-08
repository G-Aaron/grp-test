package com.grp.test.thread.lockextend;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 16:38
 **/
public class ThreadSix extends ThreadFour{
    private TempTestObject tempTestObject;
    public ThreadSix(String name, TempTestObject extendTestObject) {
        super(name, extendTestObject);
        this.tempTestObject = extendTestObject;
    }
    @Override
    public void run() {
        this.tempTestObject.print();
    }

}
