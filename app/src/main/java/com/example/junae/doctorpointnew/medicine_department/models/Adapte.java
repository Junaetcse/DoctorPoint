package com.example.junae.doctorpointnew.medicine_department.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.junae.doctorpointnew.R;

import java.util.List;

/**
 * Created by USER on 11/16/2017.
 */

public class Adapte extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataSet> DataList;

    public Adapte(Activity activity, List<DataSet> dataList) {
        this.activity = activity;
        DataList = dataList;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int position) {
        return DataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);
        TextView id= (TextView) convertView.findViewById(R.id.s_id);
        TextView name= (TextView) convertView.findViewById(R.id.s_name);
        TextView address= (TextView) convertView.findViewById(R.id.s_address);
        TextView date= (TextView) convertView.findViewById(R.id.s_number);

        DataSet m = DataList.get(position);
        id.setText(m.patient_name);
        name.setText(m.patient_date);
     /*
       id.setText(m.patientId);
        name.setText(m.patient_name);*/
        address.setText(m.patient_address);
        date.setText(m.patientId);
        return convertView;
    }
}
