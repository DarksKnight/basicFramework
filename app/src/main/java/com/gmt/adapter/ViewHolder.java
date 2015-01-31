package com.gmt.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * v0.1
 * Created by apple on 12/17/14.
 * 适配器中的 ViewHolder 类
 * 
 * @author hjt
 * @link 参考：http://www.piwai.info/android-adapter-good-practices/#Update
 * 
 */

class ViewHolder {

	@SuppressWarnings("unchecked")
	public static <T extends View> T getView(View convertView, int id) {

		SparseArray<View> holder = (SparseArray<View>) convertView.getTag();
		if (holder == null) {
			holder = new SparseArray<>();
			convertView.setTag(holder);
		}

		View view = holder.get(id);
		if (view == null) {
			view = convertView.findViewById(id);
			holder.put(id, view);
		}
		return (T) view;
	}

	public static <T extends View> T getView(View convertView, int id, int width, int height) {

		SparseArray<View> holder = (SparseArray<View>) convertView.getTag();
		if (holder == null) {
			holder = new SparseArray<>();
			convertView.setTag(holder);
		}

		View view = holder.get(id);
		if (view == null) {
			view = convertView.findViewById(id);
			ViewGroup.LayoutParams lp = view.getLayoutParams();
			if (lp != null) {
				lp.width = width;
				lp.height = height;
			}
			holder.put(id, view);
		}
		return (T) view;
	}
}
