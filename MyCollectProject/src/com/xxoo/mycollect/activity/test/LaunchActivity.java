package com.xxoo.mycollect.activity.test;

import com.xxoo.mycollect.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends FragmentActivity {
	private Button btn;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_launch);
		btn = (Button) findViewById(R.id.btn);

		Intent intent = new Intent(LaunchActivity.this, NextActivity.class);
		intent.putExtra("key", "value");
		startActivity(intent);
		finish();
	}
}
