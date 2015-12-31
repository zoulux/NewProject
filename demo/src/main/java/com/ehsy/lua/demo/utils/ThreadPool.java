package com.ehsy.lua.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lua on 2015/12/17 16:49.
 */
public class ThreadPool {

    private static  ThreadPool pool;
    public static final int THREAD_COUNT=5;
    private static  ExecutorService executor;
    public static ThreadPool getInstance() {

        if (pool==null){
            synchronized (ThreadPool.class){
                return new ThreadPool();
            }

        }

        return pool;
    }

   public  ThreadPool(){
       executor = Executors.newFixedThreadPool(THREAD_COUNT);
   }

    public static void add(Runnable run){
        executor.execute(run);
    }
}
