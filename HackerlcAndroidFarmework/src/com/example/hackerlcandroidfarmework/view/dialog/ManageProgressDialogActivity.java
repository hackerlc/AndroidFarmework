/**
 * dialog选择页面，default dialog and custom dialog
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;

public class ManageProgressDialogActivity extends BaseActivity {

	private Button defaultBtn, customBtn;

	private ProgressDialog mpDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_progress_dialog);
		initUI();
	}

	/**
	 * 初始化界面
	 */
	private void initUI() {
		defaultBtn = (Button) findViewById(R.id.defaultBtn);
		customBtn = (Button) findViewById(R.id.customBtn);

		customBtn.setOnClickListener(this);
		defaultBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.defaultBtn:
			showStyleDialog(0);
			break;
		case R.id.customBtn:
			showStyleDialog(1);
			break;
		}
	}

	/**
	 * show dialog style
	 * 
	 * @param num
	 */
	private void showStyleDialog(int num) {
		if (num == 0) {
			// 默认dialog
			mpDialog = new ProgressDialog(this);
			mpDialog.setMessage("Please wait...");
			mpDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			mpDialog.show();
			mpDialog.setOnKeyListener(new OnKeyListener() {

				@Override
				public boolean onKey(DialogInterface dialog, int keyCode,
						KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						mpDialog.dismiss();
					}
					return false;
				}
			});
		} else {
			mpDialog=new CustomProgressDialog(this,R.style.CustomProgressDialog);
			mpDialog.setMessage("Please wait...");
			mpDialog.show();
			mpDialog.setOnKeyListener(new OnKeyListener() {
				
				@Override
				public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
					if(keyCode==KeyEvent.KEYCODE_BACK){
						mpDialog.dismiss();
					}
					return false;
				}
			});
		}
	}

}
