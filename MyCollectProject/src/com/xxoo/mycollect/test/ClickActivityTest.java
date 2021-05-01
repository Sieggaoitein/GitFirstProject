package com.xxoo.mycollect.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.xxoo.mycollect.R;
import com.xxoo.mycollect.activity.test.ClickActivity;

public class ClickActivityTest extends
		ActivityInstrumentationTestCase2<ClickActivity> {

	private ClickActivity clickActivity;
	private Button btn;
	private TextView txt;

	public ClickActivityTest() {
		super(ClickActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(true);
		clickActivity = getActivity();
		btn = (Button) clickActivity.findViewById(R.id.btn);
		txt = (TextView) clickActivity.findViewById(R.id.txt);
	}

	// 待测试空间是否存在
	@SmallTest
	public void testPreConditions() {
		assertNotNull("clickActivity is null!!", clickActivity);
		assertNotNull("btn is null!!", btn);
		assertNotNull("txt is null!!", txt);
	}

	// ①测试文本初始化是现实正确文字
	@SmallTest
	public void testClickActivity_initBtnText() {
		final String expected = clickActivity.getString(R.string.btn);
		final String actual = btn.getText().toString();
		assertEquals(expected, actual);
	}

	// ②测试初始化按钮布局是否正确
	@SmallTest
	public void testClickActivity_btnLayout() {
		final View decorView = clickActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView, btn);

		final ViewGroup.LayoutParams lp = btn.getLayoutParams();

		assertNotNull(lp);
		assertEquals(lp.width, WindowManager.LayoutParams.MATCH_PARENT);
		assertEquals(lp.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}

	// ③测试初始化文本布局是否这个你却
	@SmallTest
	public void testClickActivity_txtLayout() {
		final View decorView = clickActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView, txt);

		final ViewGroup.LayoutParams lp = txt.getLayoutParams();

		assertNotNull(lp);
		assertEquals(lp.width, WindowManager.LayoutParams.MATCH_PARENT);
		assertEquals(lp.height, WindowManager.LayoutParams.MATCH_PARENT);
	}

	// ④测试按钮行为是否正确
	@MediumTest
	public void testClickActivity_clickBtnExpectInfoText() {
		String expectedInfoText = clickActivity.getString(R.string.test);
		TouchUtils.clickView(this, btn);
		assertTrue(View.VISIBLE == txt.getVisibility());
		assertEquals(expectedInfoText, txt.getText());
	}

}
