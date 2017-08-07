package com.sylvester.android.sylvesterfrancis.ConnectivityCheck;

import android.app.Application;

/**
 * Created by sylvester on 07/08/17.
 */

public class InstanceConnection extends Application {

    private static InstanceConnection mInstanceConnection;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstanceConnection = this;
    }

    public static synchronized InstanceConnection getInstance() {
        return mInstanceConnection;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

}
