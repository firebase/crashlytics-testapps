// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
