package com.example.hackerlcandroidfarmework.view;

import java.util.List;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackerlcandroidfarmework.BaseActivity;
import com.example.hackerlcandroidfarmework.R;

public class SmsActivity extends BaseActivity {

	String SENT_SMS_ACTION = "SENT_SMS_ACTION";
	String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION";
	public static final Uri SMS_URI = Uri.parse("content://sms/");
	private EditText edit_no;
	private EditText edit_body;
	private Button button;
	private String strNo;
	private String strSms;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);

		edit_no = (EditText) findViewById(R.id.phone);
		edit_body = (EditText) findViewById(R.id.body);
		button = (Button) findViewById(R.id.b_send);

		button.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.b_send:

			strNo = edit_no.getText().toString();
			strSms = edit_body.getText().toString();
			// TODO Auto-generated method stub
			/*
			 * 在 Android 2.0 以前 应该使用 android.telephony.gsm.SmsManager 之后应该用
			 * android.telephony.SmsManager;
			 */
			// 获取系统默认的短信管理器
			SmsManager smsManager = SmsManager.getDefault();
			PendingIntent sentIntent = PendingIntent.getBroadcast(
					SmsActivity.this, 0, new Intent(), 0);
			// 如果字数超过70,需拆分成多条短信发送
			// 按照每条短信最大字数来拆分短信
			if (strSms.length() > 70) {
				List<String> msgs = smsManager.divideMessage(strSms);
				for (String msg : msgs) {
					/*
					 * 发送短信
					 * 
					 * smsManager.sendTextMessage(destinationAddress, scAddress,
					 * text, sentIntent, deliveryIntent)
					 * 
					 * -- destinationAddress：目标电话号码
					 * 
					 * -- scAddress：短信中心号码，测试可以不填
					 * 
					 * -- text: 短信内容
					 * 
					 * -- sentIntent：发送 -->中国移动 --> 中国移动发送失败 --> 返回发送成功或失败信号 -->
					 * 后续处理 即，这个意图包装了短信发送状态的信息
					 * 
					 * -- deliveryIntent： 发送 -->中国移动 --> 中国移动发送成功 -->
					 * 返回对方是否收到这个信息 --> 后续处理
					 * 即：这个意图包装了短信是否被对方收到的状态信息（供应商已经发送成功，但是对方没有收到）。
					 */
					smsManager.sendTextMessage(strNo, null, msg, sentIntent,
							null);
				}
			} else {
				smsManager.sendTextMessage(strNo, null, strSms, sentIntent,
						null);
			}
			Toast.makeText(SmsActivity.this, "短信发送完成", Toast.LENGTH_LONG)
					.show();
			break;

		default:
			break;
		}
	}

}
