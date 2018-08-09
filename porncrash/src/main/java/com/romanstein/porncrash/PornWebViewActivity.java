package com.romanstein.porncrash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Roman Stein 08.08.2018.
 */
public class PornWebViewActivity extends AppCompatActivity {

    public static final String EXTRA_CLASS = "class";

    private Class<?> restartedActivity;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porn_webview);

        restartedActivity = (Class<?>) getIntent().getSerializableExtra(EXTRA_CLASS);

        getSupportActionBar().setTitle(getString(R.string.webview_title));

        WebView webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);

        webView.loadUrl(Constants.PORNHUB_URL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.webview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_restart_app) {
            if (restartedActivity != null){
                Intent intent = new Intent(PornWebViewActivity.this, restartedActivity);
                startActivity(intent);
            } else {
                Utils.startLauncherActivity(PornWebViewActivity.this);
            }

        }
        return true;
    }
}
