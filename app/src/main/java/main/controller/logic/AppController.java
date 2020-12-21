package main.controller.logic;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import main.controller.logic.stream.localStorage.LocalStorage;

/**
 * Global Lifecycle Callbacks
 * All function are in global scope
 */
public class AppController extends Application implements Application.ActivityLifecycleCallbacks {

    private static AppController appController;

    private AppController() {

    }

    private static synchronized AppController getInstance() {
        if (appController == null) {
            appController = new AppController();
        }
        return appController;
    }

    public static final AppController instance = getInstance();

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        Log.e("Global Scope", "OnCreated");
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        Log.e("Global Scope", "OnStarted");
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        Log.e("Global Scope", "OnResume");
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        Log.e("Global Scope", "OnPause");
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        Log.e("Global Scope", "OnStopped");
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        Log.e("Global Scope", "OnSaveInstance");
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        Log.e("Global Scope", "OnDestroyed");
        final LocalStorage localStorage = new LocalStorage();
        boolean save = localStorage.save(activity.getApplication());
        Log.e("Save", "Status; " + save);
    }
}
