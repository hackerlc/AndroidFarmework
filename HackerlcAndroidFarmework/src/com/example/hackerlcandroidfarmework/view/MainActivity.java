package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication.addActivity(this);
		setContentView(R.layout.activity_main);
	}

}
