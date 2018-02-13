package com.kingja.httpsir;

import android.content.Context;

import com.orhanobut.logger.Logger;


/**
 * Description:TODO
 * Create Time:2018/2/12 15:10
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HttpSir {

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (HttpClient) null);

    }

    private static RequestQueue newRequestQueue(Context context, HttpClient client) {
        if (client == null) {
            Logger.d("【创建网络访问客户端】");
            client = new HttpUrlConnectionClient();
        }
        RequestQueue queue = new RequestQueue(new DiskCache(context), client);
        queue.start();
        Logger.d("【创建队列】");
        return queue;
    }

}
