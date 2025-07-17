package com.simplebrowser.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText urlEditText;
    private ImageButton backButton, forwardButton, refreshButton, homeButton, menuButton;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View navigationMenu;
    private boolean isMenuVisible = false;
    
    private static final String HOME_URL = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeViews();
        setupWebView();
        setupButtons();
        handleIntent(getIntent());
    }
    
    private void initializeViews() {
        webView = findViewById(R.id.webview);
        urlEditText = findViewById(R.id.url_edit_text);
        backButton = findViewById(R.id.back_button);
        forwardButton = findViewById(R.id.forward_button);
        refreshButton = findViewById(R.id.refresh_button);
        homeButton = findViewById(R.id.home_button);
        menuButton = findViewById(R.id.menu_button);
        progressBar = findViewById(R.id.progress_bar);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        navigationMenu = findViewById(R.id.navigation_menu);
    }
    
    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                urlEditText.setText(url);
                updateNavigationButtons();
            }
            
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                updateNavigationButtons();
            }
            
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });
        
        // Load home page
        webView.loadUrl(HOME_URL);
    }
    
    private void setupButtons() {
        menuButton.setOnClickListener(v -> toggleNavigationMenu());
        
        backButton.setOnClickListener(v -> {
            if (webView.canGoBack()) {
                webView.goBack();
            }
            hideNavigationMenu();
        });
        
        forwardButton.setOnClickListener(v -> {
            if (webView.canGoForward()) {
                webView.goForward();
            }
            hideNavigationMenu();
        });
        
        refreshButton.setOnClickListener(v -> {
            webView.reload();
            hideNavigationMenu();
        });
        
        homeButton.setOnClickListener(v -> {
            webView.loadUrl(HOME_URL);
            urlEditText.setText(HOME_URL);
            hideNavigationMenu();
        });
        
        urlEditText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                loadUrl();
                hideNavigationMenu();
                return true;
            }
            return false;
        });
        
        swipeRefreshLayout.setOnRefreshListener(() -> webView.reload());
    }
    
    private void loadUrl() {
        String url = urlEditText.getText().toString().trim();
        if (!url.isEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                if (url.contains(".") && !url.contains(" ")) {
                    url = "https://" + url;
                } else {
                    url = "https://www.google.com/search?q=" + url;
                }
            }
            webView.loadUrl(url);
        }
    }
    
    private void updateNavigationButtons() {
        backButton.setEnabled(webView.canGoBack());
        forwardButton.setEnabled(webView.canGoForward());
        backButton.setAlpha(webView.canGoBack() ? 1.0f : 0.5f);
        forwardButton.setAlpha(webView.canGoForward() ? 1.0f : 0.5f);
    }
    
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
    
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri uri = intent.getData();
            if (uri != null) {
                String url = uri.toString();
                webView.loadUrl(url);
                urlEditText.setText(url);
            }
        }
    }
    
    @Override
    public void onBackPressed() {
        if (isMenuVisible) {
            hideNavigationMenu();
        } else if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    
    private void toggleNavigationMenu() {
        if (isMenuVisible) {
            hideNavigationMenu();
        } else {
            showNavigationMenu();
        }
    }
    
    private void showNavigationMenu() {
        navigationMenu.setVisibility(View.VISIBLE);
        isMenuVisible = true;
        updateNavigationButtons();
    }
    
    private void hideNavigationMenu() {
        navigationMenu.setVisibility(View.GONE);
        isMenuVisible = false;
    }
}