package com.xxoo.mycollect.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.xxoo.mycollect.R;
import com.xxoo.mycollect.activity.test.LaunchActivity;

public class LaunchActivityTest extends ActivityUnitTestCase<LaunchActivity> {
	private Intent launchIntent;

	public LaunchActivityTest() {
		super(LaunchActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		launchIntent = new Intent(getInstrumentation().getTargetContext(),
				LaunchActivity.class);
	}

	public void testProCondition() {
		startActivity(launchIntent, null, null);
		Button button = (Button) getActivity().findViewById(R.id.btn);

		assertNotNull("activity is null", getActivity());
		assertNotNull("button is null", button);
	}

	public void testLaunchActivity_btnText() {
		startActivity(launchIntent, null, null);

		Button btn = (Button) getActivity().findViewById(R.id.btn);

		String expectBtnText = getActivity().getString(R.string.btn);
		assertEquals("unexpectBtnText", btn.getText(), expectBtnText);
	}

	public void testLaunchActivity_wasLaunchWithIntent() {
		startActivity(launchIntent, null, null);
		Button btn = (Button) getActivity().findViewById(R.id.btn);

		btn.performClick();

		Intent launchIntent = getStartedActivityIntent();
		assertNotNull(launchIntent);
		assertTrue(isFinishCalled());
		String value = launchIntent.getStringExtra("key");
		assertEquals("value is empty", "value", value);
		
		

	}

}
