package soexample.umeng.com.ar_application.Networking;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import soexample.umeng.com.ar_application.CustomThreadExcutor;

/**
 * Created by umeng on 10/19/16.
 */
public class RequestManager {

    private static RequestManager requestManager;

    private CustomThreadExcutor mThreadPoolExecutor = new CustomThreadExcutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    private static Object mLock = new Object();

    public static RequestManager getInstance() {
        synchronized (mLock) {
            if (requestManager == null) {
                requestManager = new RequestManager();
            }
        }
        return requestManager;
    }

    public void submitTask(Request request){
        mThreadPoolExecutor.submit(request);
    }
}
