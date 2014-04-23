/**
 * 把悬挂方式放到listView
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class CustomScrollListView2Interior extends ListView {
	
	private com.example.hackerlcandroidfarmework.listener.OnScrollListener listener;

	public CustomScrollListView2Interior(Context context) {
		super(context,null);
	}

	public CustomScrollListView2Interior(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomScrollListView2Interior(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}
	
	/**
	 * 设置监听
	 */
	public void setOnScrollListener(com.example.hackerlcandroidfarmework.listener.OnScrollListener listener){
		this.listener=listener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if(listener!=null){
			listener.onScroll(t);
		}
	}
	
}
