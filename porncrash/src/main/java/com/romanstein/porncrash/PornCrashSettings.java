package com.romanstein.porncrash;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Roman Stein 08.08.2018.
 */
public class PornCrashSettings {

    public static final String APP_PREFERENCES = "porn_crash";

    public static final String APP_PREFERENCES_ADULT = "adult";

    private PornCrashSettings() {}

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static void setAdult(Context context, boolean adult){
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(APP_PREFERENCES_ADULT , adult);
        editor.commit();
    }

    public static Boolean isAdult(Context context){
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getBoolean(APP_PREFERENCES_ADULT, false);
    }
}
