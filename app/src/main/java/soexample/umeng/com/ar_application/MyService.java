package soexample.umeng.com.ar_application;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by umeng on 10/12/16.
 */
public class MyService extends IntentService {

    public MyService(String name) {
        super(name);
    }



    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
