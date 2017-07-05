package com.fantopy.beta.fantopy;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://beta.fantopy.com/");
        mWebView.setWebViewClient(new com.fantopy.beta.fantopy.MyAppWebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                findViewById(R.id.progressBar1).setVisibility(View.GONE);
                //show webview
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
