package com.romanstein.porncrashexample;

import com.romanstein.porncrash.PornCrash;

/**
 * Roman Stein 08.08.2018.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PornCrash.init(this)
                .setAdult(true)
                .setRestartedActivity(MainActivity.class)
                .build();
    }
}
