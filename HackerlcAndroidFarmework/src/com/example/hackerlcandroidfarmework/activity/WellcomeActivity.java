package com.example.hackerlcandroidfarmework.activity;

import com.example.hackerlcandroidfarmework.HackerlcApplication;

import android.app.Activity;
import android.os.Bundle;

public class WellcomeActivity extends Activity{
	
	private HackerlcApplication mApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mApplication=(HackerlcApplication)getApplication();
	}
	
	
}
