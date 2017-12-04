package com.sml.brunch;

import android.app.Application;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Smeiling on 2017/12/4.
 */

public class BrunchApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "zqNLRsv7nGx4qzNv06YvNaJL-gzGzoHsz", "OfVvWfghPpfupLOkwU2aqOri");
        AVOSCloud.setDebugLogEnabled(true);
        AVAnalytics.enableCrashReport(this, true);
    }
}
