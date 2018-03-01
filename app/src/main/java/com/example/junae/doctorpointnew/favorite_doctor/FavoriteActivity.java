package com.example.junae.doctorpointnew.favorite_doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.junae.doctorpointnew.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    DatabaseHandler dbHandler;
    List<SqliteModel> dblist;
    RecyclerView mRecyclerView;
    private FavoriteAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        mRecyclerView = (RecyclerView) findViewById(R.id.fev_recycleview);
        dbHandler = new DatabaseHandler(this);
        dblist = new ArrayList<SqliteModel>();
        dblist = dbHandler.getInformations();


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FavoriteAdapter(this, dblist);
        mRecyclerView.setAdapter(mAdapter);
    }
}
