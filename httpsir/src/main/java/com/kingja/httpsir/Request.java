package com.kingja.httpsir;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:TODO
 * Create Time:2018/2/12 14:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Request<T> implements Comparable<Request<T>> {
    private int method;
    private String url;
    private Map<String, String> params = new HashMap<>();

    @Override
    public int compareTo(@NonNull Request<T> o) {
        return 0;
    }

    public interface Method {
        public static int GET = 0;
        public static int POST = 0;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
