package com.example.junae.doctorpointnew.ambulance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.junae.doctorpointnew.R;

import java.util.List;

/**
 * Created by junae on 11/23/2017.
 */

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.MyViewHolder> {
    private List<AmbulanceModel> ambulanceModelList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ambulance_item, parent, false);
        return new AmbulanceAdapter.MyViewHolder(iView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AmbulanceModel ambulanceModel=ambulanceModelList.get(position);
        holder.latTextview.setText(ambulanceModel.getHospitalName());
        holder.longTextView.setText(ambulanceModel.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return ambulanceModelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView latTextview,longTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            latTextview= (TextView) itemView.findViewById(R.id.tv_hospital);
            longTextView= (TextView) itemView.findViewById(R.id.tv_contact);
        }


    }

    public AmbulanceAdapter(List<AmbulanceModel> ambulanceModelList) {
        this.ambulanceModelList = ambulanceModelList;
    }

}
