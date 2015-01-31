package com.gmt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * v0.2
 * Created by apple on 12/4/14.
 */
abstract class SuperAdapter<T> extends BaseAdapter {

	private final Activity mContext;
	private final List<T> mData;
	private final int mLayoutRes;
    private View convertView;

    SuperAdapter(Activity context, List<T> data, int layoutRes) {
        mContext = context;
        mData = data;
        mLayoutRes = layoutRes;
    }

	public Context getContext() {
		return mContext;
	}

	public List<T> getData() {
		return mData;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public T getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(mContext, mLayoutRes, null);
		}
        this.convertView=convertView;
		setData(position, convertView, getItem(position),parent);
		return convertView;
	}

	abstract protected void setData(int pos, View convertView, T itemData,ViewGroup parent);

	<K extends View> K $(int id) {
		return ViewHolder.getView(convertView, id);
	}

	public <K extends View> K $(int id, int width, int height) {
		return ViewHolder.getView(convertView, id, width, height);
	}
}
