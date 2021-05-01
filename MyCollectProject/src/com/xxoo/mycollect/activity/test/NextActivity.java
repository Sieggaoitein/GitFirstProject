package com.xxoo.mycollect.activity.test;

import com.xxoo.mycollect.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class NextActivity extends FragmentActivity {
	private TextView txt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_next);

		txt = (TextView) findViewById(R.id.txt);

		String value = getIntent().getStringExtra("key");
		if (!TextUtils.isEmpty(value)) {
			txt.setText(value);

		}
	}
}
