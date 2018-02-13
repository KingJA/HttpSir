package com.kingja.httpsir;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.orhanobut.logger.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description:TODO
 * Create Time:2018/2/12 15:09
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RequestQueue {
    private Cache cache;
    private HttpClient httpClient;
    private ReponseDispatcher reponseDispatcher;
    private BlockingQueue<Request<?>> cacheQueue = new PriorityBlockingQueue<>();
    private BlockingQueue<Request<?>> networkQueue = new PriorityBlockingQueue<>();
    private CacheDispatcher cacheDispatcher;
    private NetworkDispatcher networkDispatcher;

    public RequestQueue(Context context, HttpClient httpClient) {

    }

    public RequestQueue(Cache cache, HttpClient httpClient) {

        this(cache, httpClient, new ReponseDispatcher(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, HttpClient httpClient, ReponseDispatcher reponseDispatcher) {
        this.cache = cache;
        this.httpClient = httpClient;
        this.reponseDispatcher = reponseDispatcher;
    }

    public void add(Request request) {
         /*1.是否取消*/
        /*2.是否有缓存*/
        /*3.放入网络队列*/
        Logger.d("【加入网络请求队列】");
        networkQueue.add(request);
    }

    public void cancel(Object tag) {

    }

    public void start() {
        stop();
        Logger.d("【开启新的调度者】");
        cacheDispatcher = new CacheDispatcher(cacheQueue, networkQueue, cache, reponseDispatcher);
        cacheDispatcher.start();
        networkDispatcher = new NetworkDispatcher(networkQueue, httpClient, cache, reponseDispatcher);
        networkDispatcher.start();

    }

    private void stop() {
        Logger.d("【停止正在运行的调度者】");
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        if (networkDispatcher != null) {
            networkDispatcher.quit();
        }

    }
}
