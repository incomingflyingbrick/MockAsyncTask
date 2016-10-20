package soexample.umeng.com.ar_application.Interface;

import soexample.umeng.com.ar_application.Util.Log;
import android.view.View;
import soexample.umeng.com.ar_application.Networking.RequestManager;
import soexample.umeng.com.ar_application.Networking.Request;


public abstract class CallBack implements View.OnClickListener {
    static int counter = 0;
    @Override
    public void onClick(final View v) {
        Log.debug("starting some long running task");
        RequestManager.getInstance().submitTask(new Request() {

            @Override
            public void run() {
                try{
                    Thread.sleep(5000);//mock long running task,sleep thread for a while
                    Log.debug("Job done!"+Thread.currentThread().getName());
                }catch(InterruptedException e){}
            }

            @Override
            public void onStart() {
                Log.debug("start task call");
            }

            @Override
            public void onResult(String result, boolean isSuccess) {
                Log.debug(result);
                counter++;
                onComplete(result+counter,v);
            }
        });

    }

    public abstract void onComplete(String result,View v);
}
