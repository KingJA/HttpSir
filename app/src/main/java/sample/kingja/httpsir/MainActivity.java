package sample.kingja.httpsir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kingja.httpsir.HttpClient;
import com.kingja.httpsir.HttpSir;
import com.kingja.httpsir.Request;
import com.kingja.httpsir.RequestQueue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue = HttpSir.newRequestQueue(this.getApplicationContext());

        Request<Object> request = new Request<>();
        request.setUrl("http://10.1.6.186/api/todos");
        requestQueue.add(request);
    }
}
