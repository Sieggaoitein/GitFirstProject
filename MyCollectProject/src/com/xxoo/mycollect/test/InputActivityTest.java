package com.xxoo.mycollect.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xxoo.mycollect.R;
import com.xxoo.mycollect.activity.test.InputActivity;
import com.xxoo.mycollect.activity.test.NextActivity;

public class InputActivityTest extends
		ActivityInstrumentationTestCase2<InputActivity> {
	private InputActivity inputActivity;

	public InputActivityTest() {
		super(InputActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(true);
		inputActivity = getActivity();
	}


	public void testInputActivityToNext() {
		Button btnSend = (Button) inputActivity.findViewById(R.id.btn);
		final EditText edt = (EditText) inputActivity.findViewById(R.id.edt);

		Instrumentation.ActivityMonitor nextActivityMonitor = getInstrumentation()
				.addMonitor(NextActivity.class.getName(), null, false);

		getInstrumentation().runOnMainSync(new Runnable() {
			@Override
			public void run() {
				edt.requestFocus();
			}
		});

		getInstrumentation().waitForIdleSync();
		getInstrumentation()
				.sendStringSync("abcabcabcabcabcabcabcabcabcabcabc");
		getInstrumentation().waitForIdleSync();

		TouchUtils.clickView(this, btnSend);

		NextActivity nextActivity = (NextActivity) nextActivityMonitor
				.waitForActivityWithTimeout(5000);
		assertNotNull("nextactivity is null", nextActivity);
		assertEquals("monitor for nextactivity is not been called", 1,
				nextActivityMonitor.getHits());
		assertEquals("activity is of wrong type", NextActivity.class,
				nextActivity.getClass());

		TextView txt = (TextView) nextActivity.findViewById(R.id.txt);
		assertNotNull("txt is null!!", txt);
		assertEquals("wrong received message!!!",
				"abcabcabcabcabcabcabcabcabcabcabc", txt.getText().toString());

		getInstrumentation().removeMonitor(nextActivityMonitor);

	}
}
