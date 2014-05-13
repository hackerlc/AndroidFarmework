package com.example.hackerlcandroidfarmework.view;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.LinearLayout;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;
import com.example.hackerlcandroidfarmework.R.id;
import com.example.hackerlcandroidfarmework.R.layout;
import com.example.hackerlcandroidfarmework.adapter.ScrollListViewAdapter;
import com.example.hackerlcandroidfarmework.listener.OnScrollListener;
import com.example.hackerlcandroidfarmework.view.custom.CustomScrollListView2Interior;

public class ScrollListView2InteriorActivity extends BaseActivity implements OnScrollListener{
	
	private CustomScrollListView2Interior scrollDataLv;
	
	private ArrayList<String> mArray=new ArrayList<String>();
	
	/**
	 * 静止模块
	 */
	private LinearLayout mStaticModelll;
	
	/**
	 * 顶部悬挂模块
	 */
	private LinearLayout mSuspensionModelll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_list_view2_interior);
		
		initUI();
		initData();
	}

	/**
	 * 初始化界面
	 */
	private void initUI() {
		scrollDataLv=(CustomScrollListView2Interior)findViewById(R.id.scrollDataLv);
		mSuspensionModelll=(LinearLayout)findViewById(R.id.mSuspensionModelll);
		mStaticModelll=(LinearLayout)getLayoutInflater().inflate(R.layout.scroll_classify_list_view, null);
		scrollDataLv.addHeaderView(mStaticModelll);
		
		
		findViewById(R.id.parent_layout).getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener() {
			
			@Override
			public void onScrollChanged() {
				onScroll(scrollDataLv.getScrollY());
			}
		});
	}
	
	/**
	 * 模拟数据
	 */
	private void initData() {
		for(int i=0;i<30;i++){
			mArray.add("i:"+i);
		}
		scrollDataLv.setAdapter(new ScrollListViewAdapter(mArray,this));
	}

	@Override
	public void onScroll(int scrollY) {
		int mStaticModel2ParentTop = Math.max(scrollY, mStaticModelll.getTop());
		mSuspensionModelll.layout(0, mStaticModel2ParentTop, mSuspensionModelll.getWidth(),mStaticModel2ParentTop+mSuspensionModelll.getHeight());
	}

}
