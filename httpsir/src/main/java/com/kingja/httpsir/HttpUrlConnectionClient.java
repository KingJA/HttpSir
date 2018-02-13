package com.kingja.httpsir;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description:TODO
 * Create Time:2018/2/12 15:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HttpUrlConnectionClient implements HttpClient {
    @Override
    public Reponse loadNet(Request request) {
        URL url = null;
        try {
            url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();
            int responseCode = conn.getResponseCode();
            Logger.d(String.format("【返回网络响应码：%d】",responseCode));
            if (responseCode == 200) {
                String result = streamToString(conn.getInputStream());
                Logger.json(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
