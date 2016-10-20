package soexample.umeng.com.ar_application.Networking;

/**
 * Created by umeng on 10/19/16.
 */
public abstract class Request {

    String response = "";
    public boolean isSuccess = false;

    public abstract void onStart();
    public abstract void run();
    public abstract void onResult(String result,boolean isSuccess);

}
