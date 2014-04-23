/**
 * listview 选择页面， dufault listview and custom listview
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;
import com.example.hackerlcandroidfarmework.ScrollListView2InteriorActivity;



public class ManageListView extends BaseActivity{
	private Button listviewBtn,scrollListViewBtn,scrollListView2InteriorBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_listview);
		initUI();
	}
	
	/**
	 * 初始化界面
	 */
	private void initUI() {
		listviewBtn=(Button)findViewById(R.id.listviewBtn);
		scrollListViewBtn=(Button)findViewById(R.id.scrollListViewBtn);
		scrollListView2InteriorBtn=(Button)findViewById(R.id.scrollListView2InteriorBtn);
		
		listviewBtn.setOnClickListener(this);
		scrollListViewBtn.setOnClickListener(this);
		scrollListView2InteriorBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.listviewBtn:
			
			break;
		case R.id.scrollListViewBtn:
			goToActivity(this,ScrollListViewActivity.class);
			break;
		case R.id.scrollListView2InteriorBtn:
			goToActivity(this, ScrollListView2InteriorActivity.class);
			break;
		default:
			break;
		}
	}
	
}
