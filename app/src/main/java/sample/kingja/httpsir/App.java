package sample.kingja.httpsir;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Description:TODO
 * Create Time:2018/2/13 13:11
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
