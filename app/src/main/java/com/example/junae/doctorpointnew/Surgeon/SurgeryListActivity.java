package com.example.junae.doctorpointnew.Surgeon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.auth.MainActivity;
import com.example.junae.doctorpointnew.medicine_department.models.Adapte;
import com.example.junae.doctorpointnew.medicine_department.models.DataSet;
import com.example.junae.doctorpointnew.singletones.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SurgeryListActivity extends AppCompatActivity {
    private static final String tag = MainActivity.class.getSimpleName();

    String id,pdate;
    private ProgressDialog pd;
    private List<DataSet> list = new ArrayList<DataSet>();
    private ListView listView;
    private Adapte adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surgery_list);

        Intent intent = getIntent();
        id=intent.getStringExtra("id");
        pdate=intent.getStringExtra("date");

        pd = new ProgressDialog(SurgeryListActivity.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        String url= "http://techborno.com/Final_Project/Surgery/search.php?appoint_date="+pdate+"&"+"doctor_id="+id;
        pd.show();
        listView = (ListView) findViewById(R.id.surgery_listview);
        adapter = new Adapte(this, list);
        listView.setAdapter(adapter);

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.hide();


                try {

                    JSONArray jsonarray = new JSONArray(response);

                    for(int i=0; i < jsonarray.length(); i++) {

                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        DataSet dataSet = new DataSet();
                        dataSet.setPatientId(jsonobject.getString("patent_number"));
                        dataSet.setPatient_name(jsonobject.getString("patent_name"));
                        dataSet.setPatient_address(jsonobject.getString("patent_address"));
                        dataSet.setPatient_date(jsonobject.getString("appoint_date"));
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
    }
    }


