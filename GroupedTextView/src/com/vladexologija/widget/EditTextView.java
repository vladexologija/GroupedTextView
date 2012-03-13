package com.vladexologija.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

/**
 * Editable text view with label and text field
 * @author vladimir.glusac.rill
 *
 */
public class EditTextView extends LinearLayout{
	
	private LayoutInflater inflater;
	private TextView item;
	private View spacer;
	
	public EditTextView(Context context) {
		super(context);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		initialize();
	}

	public void setLabel(String label){
		item.setText(label);
	}
	
	public void setText(String text){
		item.setText(text);
	}
	
	public void showSpacer(){
		spacer.setVisibility(View.VISIBLE);
	}
	
	private void initialize() {
		 inflater.inflate(R.layout.edit_text_view, this);
		 item = (TextView) findViewById(R.id.edit_text_label);
		 spacer = (View) findViewById(R.id.spacer);
		 spacer.setVisibility(View.GONE);
	}
	

}
