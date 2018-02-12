package com.kingja.httpsir;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:TODO
 * Create Time:2018/2/12 14:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Request<T> {
    private int method;
    private String url;
    private Map<String, String> params = new HashMap<>();

    public interface Method {
        public static int GET = 0;
        public static int POST = 0;
    }
}
