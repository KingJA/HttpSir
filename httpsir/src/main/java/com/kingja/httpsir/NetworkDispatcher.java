package com.kingja.httpsir;

import com.orhanobut.logger.Logger;

import java.util.concurrent.BlockingQueue;

/**
 * Description:TODO
 * Create Time:2018/2/12 15:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class NetworkDispatcher extends Thread {
    /*网络访问队列*/
    private final BlockingQueue<Request<?>> mQueue;
    /*网络访问客户端*/
    private final HttpClient httpClient;
    /*缓存*/
    private final Cache cache;
    /*响应分发者*/
    private final ReponseDispatcher reponseDispatcher;
    private boolean mQuit;

    public NetworkDispatcher(BlockingQueue<Request<?>> networkQueue, HttpClient httpClient, Cache cache,
                             ReponseDispatcher
            reponseDispatcher) {
        this.mQueue = networkQueue;
        this.httpClient = httpClient;
        this.cache = cache;
        this.reponseDispatcher = reponseDispatcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException e) {
                if (mQuit) {
                    return;
                }
            }
        }
    }

    private void processRequest() throws InterruptedException {
        Logger.d("【开始执行网络请求】");
        Request<?> request = mQueue.take();
        Reponse reponse = httpClient.loadNet(request);
    }


    public void quit() {
        mQuit = true;
        interrupt();
    }
}
