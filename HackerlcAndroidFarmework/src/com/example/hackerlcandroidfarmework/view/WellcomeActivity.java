/**
 * 启动闪屏页面
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;

public class WellcomeActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);
		mApplication.addActivity(this);
		new Thread(mRunnable).start();
	}

	/**
	 * 启动闪屏
	 */
	Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			goToActivity(WellcomeActivity.this, MainActivity.class, true, false);
			// goToActivity(WellcomeActivity.this,
			// ManageProgressDialogActivity.class, true,false);
		}
	};

}
