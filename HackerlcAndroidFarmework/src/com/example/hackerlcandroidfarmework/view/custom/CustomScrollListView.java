/**
 * 需要悬挂方式的自定义view
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view.custom;

import com.example.hackerlcandroidfarmework.listener.OnScrollListener;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollListView extends ScrollView {

	private OnScrollListener listener;

	public CustomScrollListView(Context context) {
		super(context, null);
	}

	public CustomScrollListView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomScrollListView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * 设置滚动接口
	 * 
	 * @param listener
	 */
	public void setOnScrollListener(OnScrollListener listener) {
		this.listener = listener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (listener != null) {
			listener.onScroll(t);
		}
	}
}
