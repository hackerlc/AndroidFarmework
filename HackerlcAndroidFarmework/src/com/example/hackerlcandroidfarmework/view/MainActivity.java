package com.example.hackerlcandroidfarmework.view;

import org.apache.http.conn.ManagedClientConnection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;
import com.example.hackerlcandroidfarmework.view.dialog.ManageProgressDialogActivity;

public class MainActivity extends BaseActivity {
	
	private Button listviewLv,dialogBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication.addActivity(this);
		setContentView(R.layout.activity_main);
		initUI();
	}

	private void initUI() {
		dialogBtn=(Button)findViewById(R.id.dialogBtn);
		dialogBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.listviewBtn:
			//TODO
			//goToActivity(this, cls)
			break;
		case R.id.dialogBtn:
			goToActivity(this, ManageProgressDialogActivity.class);
			break;
		default:
			break;
		}
	}
	
	

}
