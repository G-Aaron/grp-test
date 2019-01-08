package com.grp.test.thread.syn.lockextend;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 16:38
 **/
public class ThreadFive extends ThreadFour{
    private ExtendTestObject extendTestObject;
    public ThreadFive(String name, ExtendTestObject extendTestObject) {
        super(name, extendTestObject);
        this.extendTestObject = extendTestObject;
    }
    @Override
    public void run() {
        this.extendTestObject.print();
    }

}
