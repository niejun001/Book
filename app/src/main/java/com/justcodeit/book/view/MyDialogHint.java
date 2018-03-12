package com.justcodeit.book.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.justcodeit.book.App;
import com.justcodeit.book.R;


public class MyDialogHint extends Dialog implements View.OnClickListener{
	private ImageView loading_image;
	private AnimationDrawable animationDrawable;
	private TextView dialog_hint_text_context;
	private TextView dialog_hint_text_yes;
	private TextView dialoh_hint_text_no;

	public MyDialogHint(Context context, int theme) {
		super(context, theme);
	}
	protected MyDialogHint(Context context, boolean cancelable,
                           OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}
	public MyDialogHint(Context context) {
		super(context);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_hint);
		initview();
	}
	public void initview() {
		dialog_hint_text_context = (TextView) findViewById(R.id.dialog_hint_text_context);
		dialog_hint_text_yes = (TextView) findViewById(R.id.dialog_hint_text_yes);
		dialoh_hint_text_no = (TextView) findViewById(R.id.dialoh_hint_text_no);
		dialoh_hint_text_no.setOnClickListener(this);
		dialog_hint_text_yes.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.dialoh_hint_text_no:
				dismiss();
				break;
			case R.id.dialog_hint_text_yes:
				App.getInstance().exit();
				dismiss();
				break;
		}
	}
}
