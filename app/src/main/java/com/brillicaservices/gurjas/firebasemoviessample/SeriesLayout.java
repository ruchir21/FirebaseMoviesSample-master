package com.brillicaservices.gurjas.firebasemoviessample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.brillicaservices.gurjas.firebasemoviessample.database.DatabaseHelper;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MovieListAdapter;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MoviesModelView;
import com.brillicaservices.gurjas.firebasemoviessample.series.SeriesListAdapter;
import com.brillicaservices.gurjas.firebasemoviessample.series.SeriesModelView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Set;

import static java.lang.String.valueOf;

/**
 * Created by win-8 on 19-06-2018.
 */

public class SeriesLayout extends AppCompatActivity implements SeriesListAdapter.ListItemClickListener {

    DatabaseHelper db;
    RecyclerView rv;
    SeriesListAdapter recyclerAdapter;
    ArrayList<SeriesModelView> studentArrayList = new ArrayList<SeriesModelView>();

    String Title1[] = new String[4];
    Integer rat[] = new Integer[4];
    String de[] = new String[4];
    Integer rel[] = new Integer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.series_layout);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("Series").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int i = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Title1[i] = String.valueOf(snapshot.child("name").getValue());
                    rat[i] = (Integer) snapshot.child("Rating").getValue();
                    de[i] = String.valueOf(snapshot.child("desc").getValue());
                    rel[i] = (Integer) snapshot.child("Release").getValue();

                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


                rv = findViewById(R.id.recycler_view_series);
                db = new DatabaseHelper(this);

               // studentArrayList.addAll(new SeriesModelView(Title1,rat,de,rel));
                studentArrayList.add(Title1);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                rv.setLayoutManager(linearLayoutManager);

                rv.setHasFixedSize(true);
                recyclerAdapter = new SeriesListAdapter(studentArrayList,this);
                rv.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }
    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(),studentArrayList.get(clickedItemIndex).getTitle(),Toast.LENGTH_LONG).show();
    }
}
