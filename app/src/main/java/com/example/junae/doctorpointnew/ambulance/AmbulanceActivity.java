package com.example.junae.doctorpointnew.ambulance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.interfaces.ApiInterface;
import com.example.junae.doctorpointnew.medicine_department.MedicineDepartment;
import com.example.junae.doctorpointnew.medicine_department.models.Doctorsinfo;
import com.example.junae.doctorpointnew.medicine_department.models.MedicineDoctorAdapter;
import com.example.junae.doctorpointnew.retrofit.RetrofitApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmbulanceActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<AmbulanceModel> ambulanceModels;
    private LinearLayoutManager layoutManager;
    AmbulanceAdapter ambulanceAdapter;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        recyclerView = (RecyclerView) findViewById(R.id.amb_recyclerView);
        layoutManager = new LinearLayoutManager(AmbulanceActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        ambulanceModels = new ArrayList<>();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        getAmbulance();
    }



    public void getAmbulance(){
        apiInterface.getAmbulance().enqueue(new Callback<List<AmbulanceModel>>() {
            @Override
            public void onResponse(Call<List<AmbulanceModel>> call, Response<List<AmbulanceModel>> response) {
                List<AmbulanceModel> ambulanceModelList = response.body();
                AmbulanceModel ambulanceModel=null;
                for (int i=0;i<ambulanceModelList.size();i++){
                    ambulanceModel=new AmbulanceModel();
                    String doc_Name = ambulanceModelList.get(i).getHospitalName();
                    String doc_Qualification=ambulanceModelList.get(i).getContactNumber();
                    ambulanceModel.setHospitalName(doc_Name);
                    ambulanceModel.setContactNumber(doc_Qualification);


                    ambulanceAdapter=new AmbulanceAdapter(ambulanceModelList);
                    recyclerView.setAdapter(ambulanceAdapter);


                }
            }

            @Override
            public void onFailure(Call<List<AmbulanceModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
