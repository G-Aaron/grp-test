package com.grp.test.thread.lockextend;

import com.grp.test.thread.TestObject;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-08 16:38
 **/
public class ThreadTree extends ThreadFour{
    public ThreadTree(String name, TestObject object) {
        super(name, object);
    }
    @Override
    public void run() {
        this.object.print();
    }

}
