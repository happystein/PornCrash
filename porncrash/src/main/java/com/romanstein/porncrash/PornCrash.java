package com.romanstein.porncrash;

import android.content.Context;

/**
 * Roman Stein 08.08.2018.
 */
public class PornCrash {

    private static volatile PornCrash instance;

    private Context context;

    private Class<?> name;

    private PornCrash() {}

    public void build() {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(context, name));
    }

    public static PornCrash init(Context context) {
        PornCrash localInstance = instance;
        if (localInstance == null) {
            synchronized (PornCrash.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PornCrash();
                }
            }
        }
        localInstance.context = context;
        return localInstance;
    }

    public PornCrash setAdult(boolean adult) {
        PornCrashSettings.setAdult(context, adult);
        return this;
    }

    public PornCrash setRestartedActivity(Class<?> name){
        this.name = name;
        return this;
    }

}
