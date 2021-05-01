package com.xxoo.mycollect.activity.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.xxoo.mycollect.R;

public class InputActivity extends FragmentActivity {

	private Button btn;
	private EditText edt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_input);

		btn = (Button) findViewById(R.id.btn);
		edt = (EditText) findViewById(R.id.edt);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (edt != null) {
					Intent intent = new Intent();
					intent.putExtra("key", edt.getText().toString());
					intent.setClass(InputActivity.this, NextActivity.class);
					startActivity(intent);
				}
			}
		});
	}
}
