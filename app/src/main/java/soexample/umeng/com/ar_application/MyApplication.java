package soexample.umeng.com.ar_application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by umeng on 10/20/16.
 */
public class MyApplication extends Application {

    RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        refWatcher = LeakCanary.install(this);
    }
}
