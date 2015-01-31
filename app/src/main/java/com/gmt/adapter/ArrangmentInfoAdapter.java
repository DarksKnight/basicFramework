package com.gmt.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmt.R;
import com.gmt.entity.arrangementinfo.ArrangementInfoListItem;

import java.util.List;

/**
 * Created by apple on 1/25/15.
 */
public class ArrangmentInfoAdapter extends SuperAdapter<ArrangementInfoListItem> {


    public ArrangmentInfoAdapter(Activity context, List<ArrangementInfoListItem> data) {
        super(context, data, R.layout.item_arrangmentinfo);
    }

    @Override
    protected void setData(int pos, View convertView, ArrangementInfoListItem itemData, ViewGroup parent) {
        TextView tv=$(R.id.tv);
        tv.setText(itemData.getSTANDARDSET());
    }
}
