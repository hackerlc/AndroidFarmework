/**
 * ScrollListView滚动页面
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;
import com.example.hackerlcandroidfarmework.adapter.ScrollListViewAdapter;
import com.example.hackerlcandroidfarmework.listener.OnScrollListener;
import com.example.hackerlcandroidfarmework.view.custom.CustomScrollListView;

public class ScrollListViewActivity extends BaseActivity implements OnScrollListener{
	
	private CustomScrollListView customScrollListView;
	private ListView scrollDataLv;
	
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
		setContentView(R.layout.activity_scroll_list_view);
		
		initUI();
		initData();
	}

	/**
	 * 模拟数据
	 */
	private void initData() {
		for(int i=0;i<10;i++){
			mArray.add("i:"+i);
		}
		scrollDataLv.setAdapter(new ScrollListViewAdapter(mArray,this));
	}

	private void initUI() {
		customScrollListView=(CustomScrollListView)findViewById(R.id.customScrollListView);
		scrollDataLv=(ListView)findViewById(R.id.scrollDataLv);
		mStaticModelll=(LinearLayout)findViewById(R.id.mStaticModelll);
		mSuspensionModelll=(LinearLayout)findViewById(R.id.mSuspensionModelll);
		
		customScrollListView.setOnScrollListener(this);
		
		//当布局的状态或者控件的可见性发生改变回调的接口
		findViewById(R.id.parent_layout).getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() { 
				//使得上面的购买布局和下面的购买布局重合
				onScroll(customScrollListView.getScrollY());
			}
		});
		
	}

	@Override
	public void onScroll(int scrollY) {
		int mStaticModel2ParentTop = Math.max(scrollY, mStaticModelll.getTop());
		mSuspensionModelll.layout(0, mStaticModel2ParentTop, mSuspensionModelll.getWidth(), mStaticModel2ParentTop + mSuspensionModelll.getHeight());
	}
	
}
