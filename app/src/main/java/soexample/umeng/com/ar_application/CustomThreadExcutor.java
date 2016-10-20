package soexample.umeng.com.ar_application;


import android.os.Handler;
import android.os.Looper;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import soexample.umeng.com.ar_application.Networking.Request;

/**
 * Created by umeng on 10/19/16.
 */
public class CustomThreadExcutor extends ThreadPoolExecutor {

    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public CustomThreadExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public void submit(final Request request) {
        request.onStart();
        this.execute(new Runnable() {
            @Override
            public void run() {
                request.run();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //mock result
                        request.onResult("success", true);
                    }
                });
            }
        });
    }

}
