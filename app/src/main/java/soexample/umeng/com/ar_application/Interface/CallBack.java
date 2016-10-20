package soexample.umeng.com.ar_application.Interface;

import android.util.Log;
import android.view.View;

import soexample.umeng.com.ar_application.MainActivity;
import soexample.umeng.com.ar_application.Networking.RequestManager;
import soexample.umeng.com.ar_application.Networking.Request;

/**
 * Created by umeng on 10/19/16.
 */
public abstract class CallBack implements View.OnClickListener {
    static int counter = 0;
    @Override
    public void onClick(final View v) {
        Log.d(MainActivity.TAG,"starting some long running task");
        RequestManager.getInstance().submitTask(new Request() {

            @Override
            public void run() {
                Log.d(MainActivity.TAG,"I am downloading stuff,working on "+Thread.currentThread().getName());
                try{
                    Thread.sleep(5000);
                    Log.d(MainActivity.TAG,"job done"+Thread.currentThread().getName());
                }catch(InterruptedException e){
                    Log.e(MainActivity.TAG,e.getLocalizedMessage());
                }
            }

            @Override
            public void onStart() {
                Log.d(MainActivity.TAG,"start networking call");
            }

            @Override
            public void onResult(String result, boolean isSuccess) {
                counter++;
                onComplete(result+counter,v);
            }
        });

    }

    public abstract void onComplete(String result,View v);
}
