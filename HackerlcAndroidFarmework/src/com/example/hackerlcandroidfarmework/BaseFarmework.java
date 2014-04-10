/**
 * BaseActivity 另一种实现方式
 */
package com.example.hackerlcandroidfarmework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class BaseFarmework {
	
	private Activity activity;
	private Context context;

	protected static HackerlcApplication mApplication;

	public BaseFarmework(Activity activity,Context context) {
		mApplication = HackerlcApplication.getInstance();
		this.activity=activity;
		this.context=context;
	}
	
	/**
	 * 定义了activity的快速跳转-不关闭当前activity，跳转模式为in
	 * @param context
	 * @param cls
	 */
	public void goToActivity(Class<?> cls){
		this.goToActivity(cls,false, false);
	}
	
	/**
	 * 定义了activity的快速跳转
	 * @param context 
	 * @param cls
	 * @param closeActivity 
	 * is finish
	 * @param isOut
	 * false:in or true:out
	 */
	public void goToActivity(Class<?> cls,Boolean closeActivity,Boolean isOut){
		Intent intent =new Intent(context,cls);
		context.startActivity(intent);
		if(closeActivity){
			activity.finish();
		}
	}

	/**
	 * 定义了activity的跳转样式
	 * 
	 * @param setGo
	 */
	protected void setGo(boolean isOut) {
		// 设置默认值
		int inEnter = R.anim.zoomin;
		int inExit = R.anim.zoomout;
		int outEnter = R.anim.backin;
		int outExit = R.anim.backout;

		switch (mApplication.JUMP_STYLE) {
		case 10: // 切入跳转方式
			inEnter = R.anim.zoomin;
			inExit = R.anim.zoomout;
			outEnter = R.anim.backin;
			outExit = R.anim.backout;
			break;
		default:
			break;
		}

		if (!isOut) {
			activity.overridePendingTransition(inEnter, inExit);
		} else {
			activity.overridePendingTransition(outEnter, outExit);
		}
	}
}
