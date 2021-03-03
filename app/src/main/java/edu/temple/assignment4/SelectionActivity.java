package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    int[] catImagesArray;
    Spinner spinner;
    ImageView imageView;

    boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Cat Selection");

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        ArrayList catsArray = new ArrayList<String>();
        catsArray.add("Bengal");
        catsArray.add("British Blue");
        catsArray.add("Norwegian Forest");
        catsArray.add("Persian");
        catsArray.add("Siamese");

        catImagesArray = new int[]{R.drawable.bengal, R.drawable.britishblue, R.drawable.norwegianforest, R.drawable.persian, R.drawable.siamese};

        ImageAdapter adapter = new ImageAdapter(this, catsArray, catImagesArray);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isSelected == false){
                    isSelected = true;
                }else{
                    //showPicture(position);
                    //create intent to pass information between activities
                    Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    intent.putExtra("catsArray", catsArray);
                    intent.putExtra("catImagesArray", catImagesArray);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //textView.setText
            }
        });
    }

    private void showPicture (int position) {
        imageView.setImageResource(catImagesArray[position]);
    }
}