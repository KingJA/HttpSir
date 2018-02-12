package com.kingja.httpsir;

import android.content.Context;

/**
 * Description:TODO
 * Create Time:2018/2/12 15:10
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HttpSir {

    public RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (HttpClient) null);

    }

    private RequestQueue newRequestQueue(Context context, HttpClient client) {
        if (client == null) {
            client = new HttpUrlConnectionClient();
        }
        RequestQueue queue = new RequestQueue(new DiskCache(context), client);
        queue.start();
        return queue;
    }

}
