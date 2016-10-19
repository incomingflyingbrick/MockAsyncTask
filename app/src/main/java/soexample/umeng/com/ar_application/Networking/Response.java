package soexample.umeng.com.ar_application.Networking;

import soexample.umeng.com.ar_application.Interface.NetworkCallback;

/**
 * Created by umeng on 10/19/16.
 */
public abstract class Response implements Runnable,NetworkCallback{
    String response = "";
    public boolean isSuccess = false;
}
