package com.romanstein.porncrash;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

/**
 * Roman Stein 08.08.2018.
 */
public class CrashLogger {

    public static String TAG = "PORNCRASH";

    public static void log (@NotNull Throwable throwable){
        Log.e(TAG, throwable.getMessage());

        for (StackTraceElement element : throwable.getStackTrace()){
            Log.e(TAG, element.toString());
        }
    }
}
