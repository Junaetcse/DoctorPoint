package com.example.junae.doctorpointnew.livesupport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.medicine_department.models.DataSet;

import java.util.List;

/**
 * Created by junae on 11/26/2017.
 */

public class ResponseAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ResposeModel> resposeModelList;

    public ResponseAdapter(Activity activity, List<ResposeModel> resposeModelList) {
        this.activity = activity;
        this.resposeModelList = resposeModelList;
    }

    @Override
    public int getCount() {
        return resposeModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return resposeModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.support_list_item, null);

        TextView sp_Name= (TextView) view.findViewById(R.id.sp_name);
        TextView sp_Date= (TextView) view.findViewById(R.id.sp_date);
        TextView sp_Status= (TextView) view.findViewById(R.id.sp_status);
        TextView sd_Status= (TextView) view.findViewById(R.id.sd_status);
        TextView sd_date= (TextView) view.findViewById(R.id.sd_date);
        ResposeModel resposeModel=resposeModelList.get(i);
        sp_Name.setText(resposeModel.sp_Name);
        sp_Date.setText(resposeModel.sp_Date);
        sp_Status.setText(resposeModel.sp_Status);
        sd_Status.setText(resposeModel.sd_Status);
        sd_date.setText(resposeModel.sd_Date);


        return view;
    }
}
















