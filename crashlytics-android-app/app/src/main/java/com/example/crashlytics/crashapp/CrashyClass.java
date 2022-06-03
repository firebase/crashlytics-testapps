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
