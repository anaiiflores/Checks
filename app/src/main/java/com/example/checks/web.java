package com.example.checks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class web extends Activity {

    private EditText urlEditText;
    private WebView webView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_web);

        urlEditText = findViewById(R.id.entry);
        webView = findViewById(R.id.webVi);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        Button okButton = findViewById(R.id.ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUrl();
            }
        });

        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.stopLoading();
            }
        });
    }

    private void loadUrl() {
        String url = urlEditText.getText().toString();

        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }

        webView.loadUrl(url);

    }
}
