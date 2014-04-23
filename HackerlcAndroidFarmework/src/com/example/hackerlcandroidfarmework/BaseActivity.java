/**
 * The foundation of all activities
 * @author YichenZ
 *
 */
package com.example.hackerlcandroidfarmework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class BaseActivity extends Activity implements OnClickListener{
	
	protected static HackerlcApplication mApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(mApplication==null){
			mApplication=(HackerlcApplication)getApplication();
		}
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * 定义了activity的快速跳转-不关闭当前activity，跳转模式为in
	 * @param context
	 * @param cls
	 */
	public void goToActivity(Context context,Class<?> cls){
		this.goToActivity(context, cls,false, false);
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
	public void goToActivity(Context context,Class<?> cls,Boolean closeActivity,Boolean isOut){
		Intent intent =new Intent(context,cls);
		context.startActivity(intent);
		if(closeActivity){
			finish();
		}
	}
	
	/**
	 * 定义了activity的跳转样式
	 * @param setGo
	 */
	protected void setGo(boolean isOut) {
		//设置默认值
		int inEnter=R.anim.zoomin;
		int inExit=R.anim.zoomout;
		int outEnter=R.anim.backin;
		int outExit=R.anim.backout;
		
		switch(mApplication.JUMP_STYLE){
		 case 10 : //切入跳转方式
			 inEnter=R.anim.zoomin;
			 inExit=R.anim.zoomout;
			 outEnter=R.anim.backin;
			 outExit=R.anim.backout;
			 break;
			 default:break;
		}

		if (!isOut) {
			overridePendingTransition(inEnter,inExit);
		} else{
			overridePendingTransition(outEnter,outExit);
		}
	}
	
	
	
}
