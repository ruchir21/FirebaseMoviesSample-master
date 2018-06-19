package com.brillicaservices.gurjas.firebasemoviessample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.brillicaservices.gurjas.firebasemoviessample.database.DatabaseHelper;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MoviesModelView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddNewItem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String catArray[]={"Select Genere","Series","Movies"};
    Button save;
    DatabaseHelper databaseHelper;

    EditText title;
    EditText ReleaseYear;
    EditText description;
    RatingBar rb;

    ArrayList<MoviesModelView> studentArrayList = new ArrayList<MoviesModelView>();


    Integer imagesArray[] = new Integer[]{
            R.drawable.avengers_infinity_war,
            R.drawable.avengers_infinity_war_imax_poster,
            R.drawable.dark_knight,
            R.drawable.deadpool,
            R.drawable.fast_furious_7,
            R.drawable.fight_club,
            R.drawable.godfather,
            R.drawable.hancock,
            R.drawable.harry_potter,
            R.drawable.inception,
            R.drawable.into_the_wild,
            R.drawable.iron_man_3,
            R.drawable.pursuit_of_happiness,
            R.drawable.john_wick,
            R.drawable.lion_king,
            R.drawable.rocky,
            R.drawable.shawshank_redemption,
            R.drawable.wanted};

    Spinner category, movieThumbnail;

    String categoryname;
    Integer thumbname;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);

        category = findViewById(R.id.item_category);
        ArrayAdapter<String> catAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, catArray);
        category.setAdapter(catAdapter);
        category.setPrompt(catArray[0]);
        category.setOnItemSelectedListener(this);


        movieThumbnail = findViewById(R.id.item_image);
        ArrayAdapter<Integer> movieThumbnailAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, imagesArray);
        movieThumbnail.setAdapter(movieThumbnailAdapter);
        movieThumbnail.setPrompt("Select Image");
        movieThumbnail.setOnItemSelectedListener(this);

        save = findViewById(R.id.save_item);
        title = findViewById(R.id.item_title);
        ReleaseYear = findViewById(R.id.release_year);
        description = findViewById(R.id.item_description);
        rb=findViewById(R.id.item_rating);
        databaseHelper=new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String Title = title.getText().toString();
                int Release_Year = Integer.parseInt((ReleaseYear.getText().toString()));
                String Description = description.getText().toString();
                float rbar=rb.getRating();



                if (categoryname == "Movies")
                {

                    databaseHelper.addNewMovie(new MoviesModelView(Title, Description, Release_Year, rbar,thumbname));
                    studentArrayList.addAll(databaseHelper.allMovieDetails());
                    Toast.makeText(getApplicationContext(), "Details Entered Successfully", Toast.LENGTH_LONG).show();


                }

                else
                {

                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int itemId = parent.getId();
        if(itemId == R.id.item_image)
        {
            thumbname = imagesArray[position];
        }
        else
        {
            categoryname = catArray[position];
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}