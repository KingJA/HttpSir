package com.kingja.httpsir;

import java.util.concurrent.BlockingQueue;

/**
 * Description:TODO
 * Create Time:2018/2/12 15:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CacheDispatcher extends Thread {
    private final BlockingQueue<Request<?>> cacheQueue;
    private final BlockingQueue<Request<?>> networkQueue;
    private final Cache cache;
    private final ReponseDispatcher reponseDispatcher;

    public CacheDispatcher(BlockingQueue<Request<?>> cacheQueue, BlockingQueue<Request<?>> networkQueue, Cache cache, ReponseDispatcher
            reponseDispatcher) {
        this.cacheQueue = cacheQueue;
        this.networkQueue = networkQueue;
        this.cache = cache;
        this.reponseDispatcher = reponseDispatcher;
    }
}
