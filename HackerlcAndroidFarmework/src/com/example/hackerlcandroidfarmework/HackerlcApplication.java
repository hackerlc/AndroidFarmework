/**
 * The Custom Application
 * @author YichenZ
 *
 */
package com.example.hackerlcandroidfarmework;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class HackerlcApplication extends Application {

	/**
	 * Log.i tag
	 */
	public static final String LOGTAG = "++Hackerlc_Farmaework++";

	/**
	 * 跳转样式为inOut切入方式
	 */
	public final int JUMP_STYLE = 10;

	private List<Activity> activitys = new LinkedList<Activity>();

	private static HackerlcApplication instance;

	public static HackerlcApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	/**
	 * 添加activity 入 List
	 * 
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		activitys.add(activity);
	}

	/**
	 * 退出程序
	 */
	public void exit() {
		for (Activity activity : activitys) {
			activity.finish();
		}
		System.exit(0);
	}

}
