package com.graphm.pablo.graphmessage;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by pablo on 27/11/2016.
 */

public class GraphMessageApp extends Application {

    @Override
    public void onCreate(){

        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }


}
