package com.xxoo.mycollect.activity.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xxoo.mycollect.R;

public class ClickActivity extends FragmentActivity {

	private Button btn;
	private TextView txt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_click);

		btn = (Button) findViewById(R.id.btn);
		txt = (TextView) findViewById(R.id.txt);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				txt.setVisibility(View.VISIBLE);
				txt.setText(R.string.test);
			}
		});
	}
}
