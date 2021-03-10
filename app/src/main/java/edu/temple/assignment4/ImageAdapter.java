package edu.temple.assignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] cats;

    boolean isSelected;

    public ImageAdapter(Context context, ArrayList items, int[] cats ){
        this.context = context;
        this.items = items;
        this.cats = cats;
        this.isSelected = false;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FrameLayout frameLayout;

        ImageView catImageView;
        TextView catTextView;


            frameLayout = new FrameLayout(context);
            catImageView = new ImageView(context);
            catTextView = new TextView(context);

            catTextView.setText(items.get(position));
            catTextView.setPadding(0, 0, 0, 0);
            catTextView.setTextSize(15);
            catTextView.setGravity(Gravity.CENTER);
            catTextView.setHeight(500);

            catImageView.setLayoutParams(new FrameLayout.LayoutParams(400,500));
            catImageView.setImageResource(cats[position]);
            catImageView.setPadding(0,0,0,0);


            frameLayout.addView(catImageView);
            frameLayout.addView(catTextView);



        return frameLayout;
    }


}
