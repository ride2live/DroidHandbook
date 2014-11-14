package com.example.learndroidbook;

import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	private Context context;
	String [] rubrics;

	public ListViewAdapter(Context context, String[] strings) {
		// TODO Auto-generated constructor stub
		this.context = context;
		rubrics = strings;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return rubrics.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView textItem = (TextView) LayoutInflater.from(context).inflate(R.layout.simple_list_item_new, null);
		String  [] rubricAndTag  =Utils.getTagFromResourseString(rubrics[position]);
		//HashMap< String, String> hash = 
		
		textItem.setText(rubricAndTag[0]);
		textItem.setTag(rubricAndTag[1]);
		return textItem;
	}

}
