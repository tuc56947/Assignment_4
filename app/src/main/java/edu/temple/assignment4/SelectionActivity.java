package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    int[] catImagesArray;
    Spinner spinner;
    ImageView imageView;

    TextView textView;
    boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    showPicture(position);
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