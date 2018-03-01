package com.example.junae.doctorpointnew.user_feedback;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.interfaces.ApiInterface;
import com.example.junae.doctorpointnew.retrofit.RetrofitApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends AppCompatActivity {
    String p_email;
    String ServerURL = "http://techborno.com/Final_Project/User_feedback/Medicine_doctor_ptient.php" ;

    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    String finalResult ;
    RecyclerView recyclerView;
    List<FeedbackModel> allinfofeedback;
    private LinearLayoutManager layoutManager;
    FeedbackAdapter feedbackAdapter;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Bundle bundle = getIntent().getExtras();
        p_email = bundle.getString("email");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_feedback();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.feed_recycler);
        layoutManager = new LinearLayoutManager(FeedbackActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        allinfofeedback = new ArrayList<>();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        getMedicineDoctors();
    }

    public void getMedicineDoctors(){
        apiInterface.getUserFeedback().enqueue(new Callback<List<FeedbackModel>>() {
            @Override
            public void onResponse(Call<List<FeedbackModel>> call, Response<List<FeedbackModel>> response) {
                List<FeedbackModel> doctorsinfoList = response.body();
                FeedbackModel doctorsinfo=null;
                for (int i=0;i<doctorsinfoList.size();i++){
                    doctorsinfo=new FeedbackModel();
                    String doc_Name = doctorsinfoList.get(i).getUser_mail();
                    String doc_Qualification=doctorsinfoList.get(i).getUser_feedback();
                    doctorsinfo.setUser_mail(doc_Name);
                    doctorsinfo.setUser_feedback(doc_Qualification);
                    feedbackAdapter=new FeedbackAdapter(doctorsinfoList);
                    recyclerView.setAdapter(feedbackAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<FeedbackModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void send_feedback(){
    final LayoutInflater inflater = getLayoutInflater();
    View alertLayout = inflater.inflate(R.layout.c_dialog, null);
    final EditText  c_feedback= (EditText)alertLayout.findViewById(R.id.feedback);
    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Write Feedback");
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
         String   feedback=c_feedback.getText().toString();

            UserRegisterFunction(p_email,feedback);
        }
    });
    AlertDialog dialog=alert.create();
    dialog.show();
}








    public void UserRegisterFunction(final String u_mail, final String u_feedback){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(FeedbackActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();
                finish();
                startActivity(getIntent());
                Toast.makeText(FeedbackActivity.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("mail",params[0]);

                hashMap.put("feedback",params[1]);





                finalResult = httpParse.postRequest(hashMap, ServerURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(u_mail,u_feedback);
    }


}
