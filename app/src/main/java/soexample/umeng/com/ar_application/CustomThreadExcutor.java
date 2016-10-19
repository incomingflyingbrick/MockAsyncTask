package soexample.umeng.com.ar_application;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import soexample.umeng.com.ar_application.Networking.Response;

/**
 * Created by umeng on 10/19/16.
 */
public class CustomThreadExcutor extends ThreadPoolExecutor {
    public CustomThreadExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    public void submit(Response task) {
        task.onStart();
        boolean isScuess = false;
        try{
             isScuess = super.submit(task).get()==null;
            Log.d(MainActivity.TAG,"before success");
             if(isScuess){
                 task.isSuccess = true;
                 Log.d(MainActivity.TAG,"success!");
             }
        }catch (InterruptedException e){

        }catch (ExecutionException e){

        }
        task.onResult("done loading result is:"+isScuess,isScuess);
        Log.d(MainActivity.TAG,Thread.currentThread().getName()+" haha");
    }
}
