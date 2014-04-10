/**
 * 自定义加载dialog
 * @author hackerlc
 */
package com.example.hackerlcandroidfarmework.view.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackerlcandroidfarmework.R;

public class CustomProgressDialog extends ProgressDialog{
	private ImageView loadingImg;
	private TextView loadingmsgTv;
	
	private Context context ;
	
	//public static CustomProgressDialog customProgressDialog;
	
	public CustomProgressDialog(Context context) {
		super(context);
		this.context=context;
	}
	
	public CustomProgressDialog(Context context,int theme){
		super(context, theme);
		this.context=context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//customProgressDialog=new CustomProgressDialog(context);
		setContentView(R.layout.custom_progress_dialog);
		initUI();
	}

	private void initUI() {
		loadingImg=(ImageView)findViewById(R.id.loadingImg);
		loadingmsgTv=(TextView)findViewById(R.id.loadingmsgTv);
		//The default is empty
		loadingmsgTv.setText("");
	}
	
	/**
	 * Set Title
	 */
	public void setDialogTitle(){
		//TODO This custom dialog not title
	}
	
	/**
	 * Set Message
	 * @param str 
	 * message text
	 */
	public void setMessage(String str){
		loadingmsgTv.setText(str);
	}

	@Override
	protected void onStop() {
		super.onStop();
		
	}
	
	

}
