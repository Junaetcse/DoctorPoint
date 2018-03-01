package com.example.junae.doctorpointnew.livesupport;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.auth.MainActivity;
import com.example.junae.doctorpointnew.interfaces.ApiInterface;
import com.example.junae.doctorpointnew.medicine_department.AppointmentActivity;
import com.example.junae.doctorpointnew.medicine_department.ListActivity;
import com.example.junae.doctorpointnew.medicine_department.models.Adapte;
import com.example.junae.doctorpointnew.medicine_department.models.DataSet;
import com.example.junae.doctorpointnew.retrofit.RetrofitApiClient;
import com.example.junae.doctorpointnew.singletones.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientSupport extends AppCompatActivity {
    private static final String tag = MainActivity.class.getSimpleName();
    private ProgressDialog pd;
    private List<ResposeModel> list = new ArrayList<ResposeModel>();
    private ListView listView;
    private ResponseAdapter adapter;

String p_email;
    EditText patient_status;
    Button sendProblem;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_support);
    patient_status= (EditText) findViewById(R.id.patient_status);
        sendProblem= (Button) findViewById(R.id.sendProblem);
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Bundle bundle = getIntent().getExtras();
        p_email = bundle.getString("email");
        TextView textView = new TextView(this);

        textView.setText(p_email);
      pd = new ProgressDialog(PatientSupport.this);
        pd.setMessage("loading");
        pd.setCancelable(true);
        pd.setCanceledOnTouchOutside(false);
        String url= "http://techborno.com/Final_Project/LiveSupport/search.php?userName="+p_email;
        pd.show();
        listView = (ListView) findViewById(R.id.support_Listview);
        adapter = new ResponseAdapter(this, list);
        listView.setAdapter(adapter);
    StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.hide();
                try {
                    JSONArray jsonarray = new JSONArray(response);

                    for(int i=0; i < jsonarray.length(); i++) {

                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        ResposeModel dataSet = new ResposeModel();
                        dataSet.setSp_Name(jsonobject.getString("userName"));
                        dataSet.setSp_Date(jsonobject.getString("patient_date"));
                        dataSet.setSp_Status(jsonobject.getString("status"));
                        dataSet.setSd_Status(jsonobject.getString("doctor_status"));
                        dataSet.setSd_Date(jsonobject.getString("date"));
                        list.add(dataSet);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        sendProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=p_email;
                String status=patient_status.getText().toString();
                SupportModel supportModel=new SupportModel();
                supportModel.setPatientEmail(mail);
                supportModel.setPatientStatus(status);
                Call<SupportModel> call=apiInterface.insertPatientStatus(supportModel.getPatientEmail(),supportModel.getPatientStatus());
                call.enqueue(new Callback<SupportModel>() {
                    @Override
                    public void onResponse(Call<SupportModel> call, Response<SupportModel> response) {
                        Toast.makeText(PatientSupport.this, "Successfully send problem", Toast.LENGTH_LONG).show();
                        patient_status.setText("");
                    }

                    @Override
                    public void onFailure(Call<SupportModel> call, Throwable t) {
                        Toast.makeText(PatientSupport.this, "response"+t, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }





}
