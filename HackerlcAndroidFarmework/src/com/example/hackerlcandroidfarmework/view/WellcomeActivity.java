package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;

import com.example.hackerlcandroidfarmework.BaseActivity;

public class WellcomeActivity extends BaseActivity{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication.addActivity(this);
		new Thread().start();
	}
	
	/**
	 * 启动闪屏
	 */
	Runnable mRunnable =new Runnable() {
		
		@Override
		public void run() {
			goToActivity(WellcomeActivity.this, MainActivity.class, true,false);
		}
	};

}
