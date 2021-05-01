package com.xxoo.mycollect.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xxoo.mycollect.BaseActivity;
import com.xxoo.mycollect.R;
import com.xxoo.mycollect.service.MyService;

public class ServiceActivity extends BaseActivity {
	private Button btnStart;
	private Button btnStop;
	private TextView txtLog;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_service_activity);

		init();
	}

	private void init() {
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStop = (Button) findViewById(R.id.btnStop);
		txtLog = (TextView) findViewById(R.id.txtLog);

		btnStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ServiceActivity.this,
						MyService.class);
				startService(intent);
			}
		});
		
		btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
	}
}
