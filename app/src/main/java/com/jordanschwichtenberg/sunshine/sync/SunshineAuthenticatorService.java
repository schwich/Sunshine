package com.jordanschwichtenberg.sunshine.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * The service which allows the sync adapter framework to access the authenticator.
 */
public class SunshineAuthenticatorService extends Service {
    // Instance field that stores the authenticator object
    private SunshineAuthenticator mAuthenticator;



    @Override
    public void onCreate() {
        // Create a new authenticator object
        Log.v("Hey", "Auth service created");
        mAuthenticator = new SunshineAuthenticator(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /*
         * When the system binds to this Service to make the RPC call
         * return the authenticator's IBinder.
         */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
