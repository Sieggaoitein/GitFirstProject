package com.xxoo.mycollect.model;

import android.content.Intent;

public class MainModel {
	private Intent intent;
	private String title;

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
