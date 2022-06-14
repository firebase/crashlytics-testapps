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

class CrashyClass {

  public interface Thrower {
    public void methodThatThrows();
  }

  public static void logBuildConfig() {
  }

  public void throwRuntimeException(Thrower thrower) {
    privateMethodThatThrows(thrower);
  }

  private void privateMethodThatThrows(Thrower thrower) {
    anotherPrivateMethodThatThrows(thrower);
  }

  private void anotherPrivateMethodThatThrows(Thrower thrower) {
    thrower.methodThatThrows();
  }

  public void throwBackgroundException(String msg, long delayMs) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(delayMs);
        } catch (InterruptedException e) {
          // should not occur
        }

        throwRuntimeException(() -> {
          throw new RuntimeException("Test background exception");
        });
      }
    }).start();
  }
}
