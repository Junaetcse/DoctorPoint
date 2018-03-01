package com.example.junae.doctorpointnew.favorite_doctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.diabetologist.DiabetisAppointmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junae on 12/4/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>{

    static List<SqliteModel> dblist;
    static Context context;


    public FavoriteAdapter(Context context, List<SqliteModel> dblist) {
        this.dblist = new ArrayList<SqliteModel>();
        this.context = context;
        this.dblist = dblist;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, null);
        MyViewHolder viewHolder = new MyViewHolder(layoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.latTextview.setText(dblist.get(position).getName());
        holder.longTextView.setText(dblist.get(position).getQualification());
        holder.timeTextview.setText(dblist.get(position).getDesignation());
    }

    @Override
    public int getItemCount() {
        return dblist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView latTextview,longTextView,timeTextview;

        public MyViewHolder(View itemView) {
            super(itemView);
            latTextview= (TextView) itemView.findViewById(R.id.tv_name);
            longTextView= (TextView) itemView.findViewById(R.id.tv_qualification);
            timeTextview= (TextView) itemView.findViewById(R.id.tv_designation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /**/
                    /*final int position = getAdapterPosition();
                    Log.e("position"," pos"+position);

                    Context context=v.getContext();
                    Intent intent = new Intent(context, DiabetisAppointmentActivity.class);
                    intent.putExtra("id",doctorsinfoList.get(position).getDoctorID());
                    intent.putExtra("Name",doctorsinfoList.get(position).getDoctorName());
                    intent.putExtra("qualification",doctorsinfoList.get(position).getDoctorQualification());
                    intent.putExtra("designation",doctorsinfoList.get(position).getDoctorDesignation());
                    intent.putExtra("expertise",doctorsinfoList.get(position).getDoctorExpertise());
                    intent.putExtra("organization",doctorsinfoList.get(position).getDoctorOrganization());
                    intent.putExtra("chamber",doctorsinfoList.get(position).getDoctorChamber());
                    intent.putExtra("visiting_Hours",doctorsinfoList.get(position).getDoctorVisiting_Hours());
                    intent.putExtra("location",doctorsinfoList.get(position).getDoctorLocationn());
                    intent.putExtra("phone",doctorsinfoList.get(position).getDoctorPhone());
                    intent.putExtra("email",doctorsinfoList.get(position).getDoctorEmail());
                    context.startActivity(intent);*/


                }
            });

        }


    }
}
