package com.example.hackerlcandroidfarmework;

import android.app.Application;

/**
 * The Custom Application
 * @author hackerlc
 *
 */
public class HackerlcApplication extends Application {

	/**
	 * Log.i tag 
	 */
	public static final String LOGTAG="++Hackerlc_Farmaework++";
	
	/**
	 * 跳转样式为inOut切入方式
	 */
	public static final int JUMP_STYLE=10; 
	
	private HackerlcApplication instance;

	public HackerlcApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
		
	}
	
	
	
}
