/**
 * 用户指引
 * 使用时需要注意此activity默认4张页面，如果要添加或者减少页面数量，需要在设置页面的同时，更改底部提示图的数量。
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.view;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;
import com.example.hackerlcandroidfarmework.adapter.UserGuidePagerAdapter;

public class UserGuideActivity extends BaseActivity implements
		OnPageChangeListener {
	private LinearLayout dotLL;
	private Button setHelpJumpButton1,setHelpJumpButton2,setHelpJumpButton3,setHelpJumpButton4;
	/**
	 * 容器
	 */
	private ViewPager setHelpViewpager;
	/**
	 * 图片数据适配器
	 */
	private UserGuidePagerAdapter ugpAdapter;

	private List<View> views = new ArrayList<View>();

	/**
	 * 底部指示图
	 */
	private ImageView[] dots;

	/**
	 * 当前滑动位置
	 */
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_user_guide);

		LayoutInflater layoutInflater = LayoutInflater.from(this);
		views.add(layoutInflater.inflate(R.layout.user_guide1, null));
		views.add(layoutInflater.inflate(R.layout.user_guide2, null));
		views.add(layoutInflater.inflate(R.layout.user_guide3, null));
		views.add(layoutInflater.inflate(R.layout.user_guide4, null));

		ugpAdapter = new UserGuidePagerAdapter(views);

		setHelpViewpager = (ViewPager) findViewById(R.id.setHelpViewpager);
		setHelpViewpager.setAdapter(ugpAdapter);
		setHelpViewpager.setOnPageChangeListener(this);

		initDont();
		initUI();
	}

	/**
	 * 初始化底部指示图
	 */
	private void initDont() {
		dotLL = (LinearLayout) findViewById(R.id.dotLL);

		dots = new ImageView[views.size()];

		for (int i = 0; i < views.size(); i++) {
			dots[i] = (ImageView) dotLL.getChildAt(i);
			dots[i].setEnabled(true);
			dots[i].setTag(i);
		}
		
		currentIndex=0;
		dots[currentIndex].setEnabled(false);
	}
	
	/**
	 * 设置当前引导小点的选中
	 */
	private void setCurDot(int positon) {
		if (positon < 0 || positon > views.size() - 1
				|| currentIndex == positon) {
			return;
		}

		dots[positon].setEnabled(false);
		dots[currentIndex].setEnabled(true);

		currentIndex = positon;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		setCurDot(arg0);

	}
	
	/**
	 * 初始化界面
	 */
	private void initUI() {
		setHelpJumpButton1 = (Button) views.get(0).findViewById(
				R.id.setHelpJumpButton1);
		setHelpJumpButton2 = (Button) views.get(1).findViewById(
				R.id.setHelpJumpButton2);
		setHelpJumpButton3 = (Button) views.get(2).findViewById(
				R.id.setHelpJumpButton3);
		setHelpJumpButton4 = (Button) views.get(3).findViewById(
				R.id.setHelpJumpButton4);
	}

}
