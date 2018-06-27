package com.brillicaservices.gurjas.firebasemoviessample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.brillicaservices.gurjas.firebasemoviessample.database.DatabaseHelper;
import com.brillicaservices.gurjas.firebasemoviessample.series.SeriesListAdapter;
import com.brillicaservices.gurjas.firebasemoviessample.series.SeriesModelView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Created by win-8 on 19-06-2018.
 */

public class SeriesLayout extends AppCompatActivity implements SeriesListAdapter.ListItemClickListener {

    RecyclerView rv;
    SeriesListAdapter recyclerAdapter;
    ArrayList<SeriesModelView> studentArrayList = new ArrayList<SeriesModelView>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.series_layout);

        rv = findViewById(R.id.recycler_view_series);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        rv.setHasFixedSize(true);
        recyclerAdapter = new SeriesListAdapter(studentArrayList);
        rv.setAdapter(recyclerAdapter);


       databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {

                    SeriesModelView seriesModelView = snapshot.getValue(SeriesModelView.class);

                    studentArrayList.add(seriesModelView);
                    recyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(),studentArrayList.get(clickedItemIndex).getname(),Toast.LENGTH_LONG).show();
    }
}
