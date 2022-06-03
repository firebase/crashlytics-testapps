# Crashlytics Android Testapp

Application for manual and semi-automated testing of the Crashlytics Android SDK.

## Setup

Download the `google-services.json` file from [Firebase Console](https://console.firebase.google.com/)
(for whatever Firebase project you have or want to use) and store it under the current directory.

<p align="center">
  <img src="https://i.stack.imgur.com/BFmz5.png">
</p>

> **Note:** The [Package name](https://firebase.google.com/docs/android/setup#register-app) for your
app created on the Firebase Console (for which the `google-services.json` is downloaded) must match
the [applicationId](https://developer.android.com/studio/build/application-id.html) declared in the
`app/build.gradle` for the app to link to Firebase.

## Manual testing

To build & run the app:

```
> ./gradlew app:installDebug`
> adb start com.example.crashlytics.crashapp
```

See gradle.properties for build properities which can be modified to influence
the behavior of the app.

To change a value at build time, use `-P`, i.e.:

`> ./gradlew -Pcrashapp.autoCrash=APPLICATION_ONCREATE app:installDebug`

## Semi-automated testing

One design goal of this project is to be able to run a script which builds,
installs, runs, and forces automated crashes for a variety of build & device
configurations. Manual inspection of the Crashlytics console would be used to
validate the correctness of the SDK for a number of different configurations at
once.

See `exampleTest.bsh` for an example of such a script.

## Wishlist / todos:

Things we'll add in the future:

### Properties-controlled features

* Toggle automatic data collection
* Kotlin features
* NDK
* Multi-dimensional flavors  
* Dynamic modules
* Services / multiprocess apps
* Increased control over metadata (custom logs, keys, etc.)

### Code quality & build system improvements

* Google java formatter