/*
 * Copyright (C) 2010 Vladimir Glusac Rill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vladexologija.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Layout for grouping views together in iOS style
 * @author vladimir.glusac.rill
 */
public class GroupedTextView extends LinearLayout {
	
	private Context context;
	private LayoutInflater layoutInflater;
	private LinearLayout itemsContainer;

	public GroupedTextView(Context context) {
		super(context);
		initialize(context);
	}

	public GroupedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	private void initialize(Context context) {
		this.context = context;
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.grouped_text_view, this);
		itemsContainer = (LinearLayout) findViewById(R.id.items_container);
		itemsContainer.setVisibility(View.GONE);
	}

	public void addField(View v) {
		itemsContainer.addView(v);
	}

	public void addField(View v, LayoutParams layoutParams) {
		itemsContainer.addView(v, layoutParams);
	}

	public void addFieldAt(View v, int index) {
		itemsContainer.addView(v, index);
	}
	
	/**
	 * Adds plain text field to group
	 * @param text
	 */
	public void addPlainTextView(String text) {	
		PlainTextView item = new PlainTextView(context);
		item.setText(text);		
		
		if (isEmpty()) {
			itemsContainer.setVisibility(View.VISIBLE);			
		} else {
			((PlainTextView) getLastField()).showSpacer();
		}
			
		addField(item);
	}
	
	/**
	 * Adds edit text field to group
	 * @param label
	 * @param text
	 */
	public void addEditTextView(String label, String text) {		
		EditTextView item = new EditTextView(context);
		item.setLabel(label);
		item.setText(text);	
		
		if (isEmpty()) {
			itemsContainer.setVisibility(View.VISIBLE);
		} else {
			((EditTextView) getLastField()).showSpacer();
		}		
		addField(item);
	}
	
	/**
	 * Removes passed view from group
	 * @param view
	 */
	public void removeField(View view) {
		itemsContainer.removeView(view);
	}
	
	/**
	 * Removes field at index
	 * @param index
	 */
	public void removeFieldAt(int index) {
		itemsContainer.removeViewAt(index);
	}
	
	/*
	 * Clears all fields and hides group
	 */
	public void removeAllFields() {
		itemsContainer.setVisibility(View.GONE);
		itemsContainer.removeAllViews();
	}
	
	/**
	 * Returns number of fields in the group
	 * @return
	 */
	public int size() {
		return itemsContainer.getChildCount();
	}

	/**
	 * Checks is the group empty
	 * @return
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	/**
	 * Returns View from location
	 * @param index
	 * @return
	 */
	public View getFieldViewAt(int index) {
		return itemsContainer.getChildAt(index);
	}
	
	/**
	 * Returns last field
	 * @return
	 */
	public View getLastField() {
		View view = null;
		if (!isEmpty()){
			view =  itemsContainer.getChildAt(itemsContainer.getChildCount() - 1);
		}
		return view;
	}


}
