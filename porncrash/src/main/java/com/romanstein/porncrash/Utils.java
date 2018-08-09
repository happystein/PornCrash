package com.romanstein.porncrash;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import org.jetbrains.annotations.NotNull;

/**
 * Roman Stein 09.08.2018.
 */
public class Utils {

    public static void startLauncherActivity(@NotNull  Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
    }
}
