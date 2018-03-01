package com.example.junae.doctorpointnew.user_feedback;

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
 * Created by junae on 12/6/2017.
 */

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.MyViewHolder>{
    private List<FeedbackModel> allFeedback;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.c_item, parent, false);
        return new MyViewHolder(iView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
   FeedbackModel getFeedback=allFeedback.get(position);
        holder.u_fName.setText(getFeedback.getUser_mail());
        holder.u_feedbak.setText(getFeedback.getUser_feedback());
    }

    @Override
    public int getItemCount() {
        return allFeedback.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView u_fName,u_feedbak;

        public MyViewHolder(View itemView) {
            super(itemView);
            u_fName= (TextView) itemView.findViewById(R.id.tv_name);
            u_feedbak= (TextView) itemView.findViewById(R.id.tv_feedback);

        }


    }

    public FeedbackAdapter(List<FeedbackModel> allFeedback) {
        this.allFeedback = allFeedback;
    }
}
