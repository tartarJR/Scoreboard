package com.tatar.scoreboard;

import android.app.Application;

import com.tatar.scoreboard.di.AppComponent;
import com.tatar.scoreboard.di.DaggerAppComponent;
import com.tatar.scoreboard.di.modules.ContextModule;

/**
 * Created by mobile on 26.02.2018.
 */

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    public AppComponent buildAppComponent() {
        return DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }

}
