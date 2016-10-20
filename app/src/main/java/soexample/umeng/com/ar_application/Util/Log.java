package soexample.umeng.com.ar_application.Util;

/**
 * Created by umeng on 10/20/16.
 */
public class Log {
    private static String TAG = "AR_APP";
    public static void debug(String message){
        android.util.Log.d(TAG,message);
    }
}
