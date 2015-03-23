package com.toubou91.expandablelistview;

import com.example.expandablelist.R;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	public TextView text;
	public ImageView imageview;

	public ViewHolder(View v) {
		this.text = (TextView) v.findViewById(R.id.text1);
		this.imageview = (ImageView) v.findViewById(R.id.image1);
	}

}
