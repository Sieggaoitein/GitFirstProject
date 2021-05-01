package com.xxoo.mycollect.activity;

import java.net.URISyntaxException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.xxoo.mycollect.BaseActivity;
import com.xxoo.mycollect.R;

public class WebViewActivity extends BaseActivity {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private WebView mWebView;
	private String url;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_webview);
		initComponents();

	}

	private void initComponents() {
		url = "file:///android_asset/local.html";
		// url = "https://kyfw.12306.cn/otn/";
		// url = "http://www.baidu.com";
		// url = "https://www.789789789.com/";
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		mWebView = (WebView) findViewById(R.id.common_web_page_webview);

		// 加载https的请求
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
			}

			@Override
			public void onPageFinished(WebView view, String url) {
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(WebViewActivity.this, "Oh no! " + description,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onReceivedHttpAuthRequest(WebView view,
					HttpAuthHandler handler, String host, String realm) {
				super.onReceivedHttpAuthRequest(view, handler, host, realm);
			}

			@Override
			public void onReceivedLoginRequest(WebView view, String realm,
					String account, String args) {
				super.onReceivedLoginRequest(view, realm, account, args);
			}

			@Override
			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, SslError error) {
				handler.proceed();
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				WebViewActivity.this.setProgress(1000 * newProgress);
			}
		});

		mWebView.addJavascriptInterface(new Object() {
			@JavascriptInterface
			public void showToast(String param) {
				Toast.makeText(WebViewActivity.this, param, Toast.LENGTH_SHORT)
						.show();
			}
		}, "handlerUnKnowByWeb");

		mWebView.addJavascriptInterface(new Object() {
			@JavascriptInterface
			public void openActivity(String param) {
				try {
					startActivity(Intent.parseUri(param,
							Intent.URI_INTENT_SCHEME));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}, "handlerUnKnowByWeb1");

		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.clearCache(true);
		mWebView.getSettings().setDefaultTextEncodingName("utf-8");
		mWebView.getSettings().setLoadsImagesAutomatically(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		if (url != null && url.trim().length() > 0) {
			mWebView.loadUrl(url);
		}

		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(WebViewActivity.this, MainActivity.class);
				intent.putExtra("key1", "value1");
				intent.putExtra("key2", "value2");
				Log.e("-------", intent.toUri(0));
				Log.e("-------", intent.toUri(Intent.URI_INTENT_SCHEME));
				mWebView.loadUrl("javascript:click1()");
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("http://www.baidu.com");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
	}
}
