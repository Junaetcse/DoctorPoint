package com.example.junae.doctorpointnew.orthopedics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.interfaces.ApiInterface;
import com.example.junae.doctorpointnew.medicine_department.models.Doctorsinfo;
import com.example.junae.doctorpointnew.retrofit.RetrofitApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrthopedicsDepartment extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Doctorsinfo> doctorlist;
    private LinearLayoutManager layoutManager;
    OrthopedicesDoctorAdapter orthopedicesDoctorAdapter;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orthopedics_department);
        recyclerView = (RecyclerView) findViewById(R.id.orthopedics_recyclerView);
        layoutManager = new LinearLayoutManager(OrthopedicsDepartment.this);
        recyclerView.setLayoutManager(layoutManager);

        doctorlist = new ArrayList<>();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        getMedicineDoctors();
    }


    public void getMedicineDoctors() {
        apiInterface.getOrthopedicDoctors().enqueue(new Callback<List<Doctorsinfo>>() {
            @Override
            public void onResponse(Call<List<Doctorsinfo>> call, Response<List<Doctorsinfo>> response) {
                List<Doctorsinfo> doctorsinfoList = response.body();
                Doctorsinfo doctorsinfo = null;
                for (int i = 0; i < doctorsinfoList.size(); i++) {
                    doctorsinfo = new Doctorsinfo();
                    String doc_Name = doctorsinfoList.get(i).getDoctorName();
                    String doc_Qualification = doctorsinfoList.get(i).getDoctorQualification();
                    String doc_Designation = doctorsinfoList.get(i).getDoctorDesignation();
                    doctorsinfo.setDoctorName(doc_Name);
                    doctorsinfo.setDoctorDesignation(doc_Designation);
                    doctorsinfo.setDoctorQualification(doc_Qualification);

                    orthopedicesDoctorAdapter = new OrthopedicesDoctorAdapter(doctorsinfoList);
                    recyclerView.setAdapter(orthopedicesDoctorAdapter);


                }
            }

            @Override
            public void onFailure(Call<List<Doctorsinfo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
