/**
 * 主要功能跳转界面
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;

public class MainActivity extends BaseActivity {
	
	private Button listviewBtn,dialogBtn,UserGuideBtn,SmsBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication.addActivity(this);
		setContentView(R.layout.activity_main);
		
		initUI();
	}

	private void initUI() {
		listviewBtn=(Button)findViewById(R.id.listviewBtn);
		dialogBtn=(Button)findViewById(R.id.dialogBtn);
		UserGuideBtn=(Button)findViewById(R.id.UserGuideBtn);
		SmsBtn=(Button)findViewById(R.id.SmsBtn);
		listviewBtn.setOnClickListener(this);
		dialogBtn.setOnClickListener(this);
		UserGuideBtn.setOnClickListener(this);
		SmsBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.listviewBtn:
			goToActivity(this,ManageListView.class);
			break;
		case R.id.dialogBtn:
			goToActivity(this, ManageProgressDialogActivity.class);
			break;
		case R.id.UserGuideBtn:
			goToActivity(this, UserGuideActivity.class);
			break;
		case R.id.SmsBtn:
			goToActivity(this, SmsActivity.class);
			break;
		default:
			break;
		}
	}
	
	

}
