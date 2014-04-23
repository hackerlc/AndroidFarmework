package com.example.hackerlcandroidfarmework.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hackerlcandroidfarmework.R;

public class ScrollListViewAdapter extends BaseAdapter {
	
	private ArrayList<String> mArray ;
	private LayoutInflater inflater;
	
	public ScrollListViewAdapter(ArrayList<String> array,Context context){
		mArray=array;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mArray.size();
	}

	@Override
	public Object getItem(int position) {
		return mArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView=inflater.inflate(R.layout.item_demo, null);
		}
		return convertView;
	}

}
