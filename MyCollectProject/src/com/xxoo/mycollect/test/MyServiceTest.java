package com.xxoo.mycollect.test;

import android.content.Intent;
import android.test.ServiceTestCase;

import com.xxoo.mycollect.service.MyService;

public class MyServiceTest extends ServiceTestCase<MyService> {
	public MyServiceTest() {
		super(MyService.class);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testStart() {
		startService(new Intent(getContext(), MyService.class));
		assertNotNull(getService());
	}

	public void testStop() {
		Intent intent = new Intent(getContext(), MyService.class);
		startService(intent);
		MyService service = getService();
		service.stopService(intent);
	}
}
