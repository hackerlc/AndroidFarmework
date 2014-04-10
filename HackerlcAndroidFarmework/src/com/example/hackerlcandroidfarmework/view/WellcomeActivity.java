package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.view.dialog.ManageProgressDialogActivity;

public class WellcomeActivity extends BaseActivity{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication.addActivity(this);
		new Thread(mRunnable).start();
	}
	
	/**
	 * 启动闪屏
	 */
	Runnable mRunnable =new Runnable() {
		
		@Override
		public void run() {
			//goToActivity(WellcomeActivity.this, MainActivity.class, true,false);
			goToActivity(WellcomeActivity.this, ManageProgressDialogActivity.class, true,false);
		}
	};

}
