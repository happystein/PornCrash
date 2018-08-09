package com.romanstein.porncrash;

import android.content.Context;
import android.content.Intent;

/**
 * Roman Stein 08.08.2018.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Context context;

    private Class<?> name;

    /**
     * @param context - Context
     * @param name    - Restarted Activity
     */

    public ExceptionHandler(Context context, Class<?> name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        CrashLogger.log(throwable);

        if (PornCrashSettings.isAdult(context)) {
            Intent intent = new Intent(context, PornWebViewActivity.class);
            intent.putExtra(PornWebViewActivity.EXTRA_CLASS, name);
            context.startActivity(intent);
        } else {
            if (name != null) {
                Intent intent = new Intent(context, name);
                context.startActivity(intent);
            } else {
                Utils.startLauncherActivity(context);
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }


}
