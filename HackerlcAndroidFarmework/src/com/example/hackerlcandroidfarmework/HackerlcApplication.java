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
	public static String LOGTAG="++Hackerlc_Farmaework++";
	
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
