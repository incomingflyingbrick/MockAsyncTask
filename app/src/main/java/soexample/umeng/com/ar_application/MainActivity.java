package soexample.umeng.com.ar_application;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.ar_application.Interface.CallBack;

/**
 * try to implement a simple version of asynctask, with paralle excutetion by default
 */
public class MainActivity extends AppCompatActivity {

    public static String TAG="thread";

    @BindView(R.id.my_button) Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //update the text on button,everytime you click it. It use a thread pool to run tasks for mock computation
        mButton.setOnClickListener(new CallBack() {
            @Override
            public void onComplete(String result,View v) {
                ((TextView)v).setText(result);
            }
        });

    }
}
