package com.example.junae.doctorpointnew.design_part;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junae.doctorpointnew.R;
import com.example.junae.doctorpointnew.Surgeon.SurgeonDepartment;
import com.example.junae.doctorpointnew.ambulance.AmbulanceActivity;
import com.example.junae.doctorpointnew.cardiologyest.CardioDepartment;
import com.example.junae.doctorpointnew.dentist.DentDepartment;
import com.example.junae.doctorpointnew.diabetologist.DiabetologistDepartment;
import com.example.junae.doctorpointnew.ent.EntDepartment;
import com.example.junae.doctorpointnew.favorite_doctor.FavoriteActivity;
import com.example.junae.doctorpointnew.gastrologist.GastrologistDepartment;
import com.example.junae.doctorpointnew.gynecology.GynecologyDepartment;
import com.example.junae.doctorpointnew.livesupport.PatientSupport;
import com.example.junae.doctorpointnew.medicine_department.MedicineDepartment;
import com.example.junae.doctorpointnew.neuromedicine.NeuromedicineDepartment;
import com.example.junae.doctorpointnew.orthopedics.OrthopedicsDepartment;
import com.example.junae.doctorpointnew.urologist.UrologistDepartment;
import com.example.junae.doctorpointnew.user_feedback.FeedbackActivity;

public class DesignActivity extends AppCompatActivity {
    GridLayout gridLayout;
    String patient_email;
    String UserEmail = "";
    String email;
    static final int CUSTOM_DIALOG_ID = 0;
    ListView dialog_ListView;
    String[] listContent = {
            "Medicine Department", "Surgery Department", "Cardiologist Department", "Diabetology Department",
            "Neuromedicine Department", "Gastrology Department","Urologist Department", "ENT Department",
            "Orthopedics Department", "Dental surgon Department", "Gynaecology Department"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        gridLayout= (GridLayout) findViewById(R.id.mainGride);
        setSingeEvent(gridLayout);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        TextView textView = new TextView(this);
        textView.setText(email);
    }
    private void setSingeEvent(GridLayout mainGride){
        for (int i=0; i<mainGride.getChildCount();i++){
            CardView cardView= (CardView) mainGride.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI==0){
                        //Toast.makeText(DesignActivity.this,"Click at  111",Toast.LENGTH_SHORT).show();
                        showDialog(CUSTOM_DIALOG_ID);
                    }
                    if (finalI==1){
                        Intent intent=new Intent(DesignActivity.this, AmbulanceActivity.class);
                        startActivity(intent);
                    }
                    if (finalI==2){
                        Intent intent=new Intent(DesignActivity.this, PatientSupport.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("email",email );
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if (finalI==3){
                        Intent intent=new Intent(DesignActivity.this, FeedbackActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("email",email );
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }
            });

        }
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch(id) {
            case CUSTOM_DIALOG_ID:
                dialog = new Dialog(DesignActivity.this);
                dialog.setContentView(R.layout.dialoglayout);
                dialog.setTitle("Custom Dialog");
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener(){

                    @Override
                    public void onCancel(DialogInterface dialog) {
// TODO Auto-generated method stub
                        Toast.makeText(DesignActivity.this,
                                "Cancel...",
                                Toast.LENGTH_LONG).show();
                    }});
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener(){

                    @Override
                    public void onDismiss(DialogInterface dialog) {
// TODO Auto-generated method stub
                        Toast.makeText(DesignActivity.this,
                                "Success...",
                                Toast.LENGTH_LONG).show();
                    }});

                dialog_ListView = (ListView)dialog.findViewById(R.id.dialoglist);
                ArrayAdapter<String> adapter
                        = new ArrayAdapter<String>(this,
                        android.R.layout.simple_expandable_list_item_1, listContent);
                dialog_ListView.setAdapter(adapter);
                dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                    if (position==0){
                        Intent intent=new Intent(DesignActivity.this, MedicineDepartment.class);
                        startActivity(intent);
                    }
                        if (position==1){
                            Intent intent=new Intent(DesignActivity.this, SurgeonDepartment.class);
                            startActivity(intent);
                        }
                        if (position==2){
                            Intent intent=new Intent(DesignActivity.this, CardioDepartment.class);
                            startActivity(intent);
                        }
                        if (position==3){
                            Intent intent=new Intent(DesignActivity.this, DiabetologistDepartment.class);
                            startActivity(intent);
                        }
                        if (position==4){
                            Intent intent=new Intent(DesignActivity.this, NeuromedicineDepartment.class);
                            startActivity(intent);
                        }
                        if (position==5){
                            Intent intent=new Intent(DesignActivity.this, GastrologistDepartment.class);
                            startActivity(intent);

                        }if (position==6){
                            Intent intent=new Intent(DesignActivity.this, UrologistDepartment.class);
                            startActivity(intent);
                        }
                        if (position==7){
                            Intent intent=new Intent(DesignActivity.this, EntDepartment.class);
                            startActivity(intent);
                        }
                        if (position==8){
                            Intent intent=new Intent(DesignActivity.this, OrthopedicsDepartment.class);
                            startActivity(intent);
                        }
                        if (position==9){
                            Intent intent=new Intent(DesignActivity.this, DentDepartment.class);
                            startActivity(intent);
                        }
                        if (position==10){
                            Intent intent=new Intent(DesignActivity.this, GynecologyDepartment.class);
                            startActivity(intent);
                        }
                        dismissDialog(CUSTOM_DIALOG_ID);
                    }});

                break;
        }
        return dialog;
    }
    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle bundle) {
// TODO Auto-generated method stub
        super.onPrepareDialog(id, dialog, bundle);
        switch(id) {
            case CUSTOM_DIALOG_ID:
                break;
        }
    }
}
