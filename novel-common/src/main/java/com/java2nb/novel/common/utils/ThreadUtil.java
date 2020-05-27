package com.java2nb.novel.common.utils;

/**
 * 线程工具类
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/23
 */
public class ThreadUtil {

    /**
     * 根据线程ID获取线程
     * */
    public static Thread findThread(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadId == threads[i].getId()) {
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }
}
