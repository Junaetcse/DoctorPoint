package com.example.junae.doctorpointnew.gynecology;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.interfaces.ApiInterface;
import com.example.junae.doctorpointnew.medicine_department.models.AppointDoctor;
import com.example.junae.doctorpointnew.medicine_department.models.Doctorsinfo;
import com.example.junae.doctorpointnew.retrofit.RetrofitApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GynecologyAppointment extends AppCompatActivity {
    TextView doctor_Name;
    TextView doctor_Qualification;
    TextView doctor_Designation;
    TextView doctor_expertise;
    TextView doctor_organization;
    TextView doctor_chamber;
    TextView doctor_visiting_Hours;
    TextView doctor_location;
    TextView doctor_phone;
    TextView doctor_email;

    String id;
    private ApiInterface apiInterface;
    private List<Doctorsinfo> doctorsinfoList;
    int position;
    public Doctorsinfo doctorsinfo;

    //show patient......................>
    ListView result;
    EditText phoneN;
    Button search;
    String number;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gynecology_appointment);
        initialize();
        doctorsinfo=new Doctorsinfo();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Intent intent = getIntent();
        id=intent.getStringExtra("id");
        String name = intent.getStringExtra("Name");
        String Qualification = intent.getStringExtra("qualification");
        String Designation = intent.getStringExtra("designation");
        String expertise = intent.getStringExtra("expertise");
        String organization = intent.getStringExtra("organization");
        String chamber = intent.getStringExtra("chamber");
        String visiting_Hours = intent.getStringExtra("visiting_Hours");
        String location = intent.getStringExtra("location");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");

        //doctor_id.setText(id);
        doctor_Name.setText(name);
        doctor_Qualification.setText(Qualification);
        doctor_Designation.setText(Designation);
        doctor_expertise.setText(expertise);
        doctor_organization.setText(organization);
        doctor_chamber.setText(chamber);
        doctor_visiting_Hours.setText(visiting_Hours);
        doctor_location.setText(location);
        doctor_phone.setText(phone);
        doctor_email.setText(email);



        //show patient searial...........................>

        pd = new ProgressDialog(GynecologyAppointment.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText userDate = new EditText(GynecologyAppointment.this);
                android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(GynecologyAppointment.this);
                alert.setTitle("Appoint Date (__/__/__)");
                alert.setView(userDate);
                alert.setCancelable(false);
                alert.setNegativeButton("Cencle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();

                    }
                });

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number = userDate.getText().toString().trim();

                        Intent intent = new Intent(GynecologyAppointment.this, GynecologyListActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("date", number);
                        startActivity(intent);
                    }
                });
                android.support.v7.app.AlertDialog dialog=alert.create();
                dialog.show();
            }
        });
    }



    public void gynecology_appointment(View view){
        final LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);


        final EditText userSerial = (EditText) alertLayout.findViewById(R.id.patent_serial);
        final EditText userDate = (EditText) alertLayout.findViewById(R.id.appoint_date);
        final EditText userName = (EditText) alertLayout.findViewById(R.id.patent_name);
        final EditText userAddress = (EditText) alertLayout.findViewById(R.id.patent_address);
        final EditText userNumber= (EditText) alertLayout.findViewById(R.id.patent_number);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Add Appoint Info");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cencle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
                AppointDoctor appointDoctor=new AppointDoctor();
                //String doctorId=String.valueOf(doctor_id);

                appointDoctor.setDoctorId(id);
                appointDoctor.setPatientSerial(userSerial.getText().toString());
                appointDoctor.setPatientDate(userDate.getText().toString());
                appointDoctor.setPatientName(userName.getText().toString());
                appointDoctor.setPatientAddress(userAddress.getText().toString());
                appointDoctor.setPatientNumber(userNumber.getText().toString());
                Call<AppointDoctor> call=apiInterface.insertGynecologyPatient(appointDoctor.getDoctorId(),appointDoctor.getPatientSerial(),
                        appointDoctor.getPatientDate(),appointDoctor.getPatientName(),appointDoctor.getPatientAddress(),appointDoctor.getPatientNumber());
                call.enqueue(new Callback<AppointDoctor>() {
                    @Override
                    public void onResponse(Call<AppointDoctor> call, Response<AppointDoctor> response) {
                        Toast.makeText(GynecologyAppointment.this, "Successfully Appointed . Date is:   "+userDate, Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onFailure(Call<AppointDoctor> call, Throwable t) {
                        Toast.makeText(GynecologyAppointment.this, "response"+t, Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

        AlertDialog dialog=alert.create();
        dialog.show();
    }

    public void initialize(){
        //doctor_id= (TextView) findViewById(R.id.doctor_id);
        doctor_Name = (TextView) findViewById(R.id.doctor_name);
        doctor_Qualification = (TextView) findViewById(R.id.doctor_qualification);
        doctor_Designation = (TextView) findViewById(R.id.doctor_designation);
        doctor_expertise = (TextView) findViewById(R.id.doctor_expertis);
        doctor_organization = (TextView) findViewById(R.id.doctor_organization);
        doctor_chamber = (TextView) findViewById(R.id.doctor_chamber);
        doctor_visiting_Hours = (TextView) findViewById(R.id.doctor_visit);
        doctor_location = (TextView) findViewById(R.id.doctor_location);
        doctor_phone = (TextView) findViewById(R.id.doctor_phone);
        doctor_email = (TextView) findViewById(R.id.doctor_email);

        search = (Button)findViewById(R.id.gynecology_search);

    }
}
