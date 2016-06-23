package com.plexxoo.android.test;
import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestListAdapter extends BaseAdapter {
	
	private ArrayList<String> strings;
	private Context context;

	public TestListAdapter(Context context, String [] cadenas) {
		strings=new ArrayList();
		try{
		for(int i=0;i<cadenas.length;i++){
			this.strings.add(cadenas[i]);
		}
		}catch(Exception e){
			
		}
		this.context = context;
	}

	public int getCount() {
		return strings.size();
	}

	public String getItem(int position) {
		return (null == strings) ? null : strings.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tli;
		if (null == convertView) {
			tli = (TextView)View.inflate(context, R.layout.item, null);
		} else {
			tli = (TextView)convertView;
		}
		tli.setText(strings.get(position));
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}
	public void add(String s){
		strings.add(s);
	}
	public void remove(int i){
		strings.remove(i);
	}
	public void remove(String s){
		strings.remove(s);
	}
	

}
