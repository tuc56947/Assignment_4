package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ArrayList<String> catsArray;
    int[] catImagesArray;
    int position;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        //get intent
        Intent intent = getIntent();

        catsArray =(ArrayList<String>) intent.getSerializableExtra("catsArray");
        position = intent.getIntExtra("position", 0);
        Bundle bundle = getIntent().getExtras();
        catImagesArray = bundle.getIntArray("catImagesArray");

        textView.setText(catsArray.get(position));
        textView.setGravity(Gravity.CENTER);
        imageView.setImageResource(catImagesArray[position]);
    }
}