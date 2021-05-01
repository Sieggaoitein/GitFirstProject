package com.xxoo.mycollect.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.xxoo.mycollect.BaseActivity;
import com.xxoo.mycollect.R;

public class WebViewNextActivity extends BaseActivity {
	private TextView mTxt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_webview_next);

		mTxt = (TextView) findViewById(R.id.txt);

		Intent intent = getIntent();
		String value1 = intent.getStringExtra("key1");
		String value2 = intent.getStringExtra("key2");

		if (!TextUtils.isEmpty(value1)) {
			mTxt.setText(value1);
		}
		if (!TextUtils.isEmpty(value2)) {
			mTxt.setText(mTxt.getText() + "---" + value2);
		}
	}
}
