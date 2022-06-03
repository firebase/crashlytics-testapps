package com.example.crashlytics.crashapp;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
  public final static String LOGTAG = "CrashApp";

  @Override
  public void onCreate() {
    super.onCreate();

    if(BuildConfig.CRASHAPP_AUTOCRASH.equals(ConfigConstants.AUTOCRASH_APPLICATION_ONCREATE)) {
      Log.d(LOGTAG, "Application#onCreate crash initiated from BuildConfig");
      new CrashyClass().throwRuntimeException(() -> {
        throw new RuntimeException("Test crash in Application#onCreate");
      });
    }
  }
}
