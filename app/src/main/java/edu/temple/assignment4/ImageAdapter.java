package edu.temple.assignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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


        TextView textView = new TextView(context);
        if(isSelected == false){
            textView.setText("Select a cat: ");
        }else{
            textView.setText(items.get(position));
        }
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;

        ImageView catImageView;
        TextView catTextView;

        isSelected = false;

        if (convertView == null){
            linearLayout = new LinearLayout(context);
            catImageView = new ImageView(context);
            catTextView = new TextView(context);

            catTextView.setPadding(10, 15, 15, 15);
            catTextView.setTextSize(22);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(catImageView);
            linearLayout.addView(catTextView);
            catImageView.getLayoutParams().height = 150;
            catImageView.getLayoutParams().width = 150;
        } else{
            linearLayout = (LinearLayout) convertView;
            catImageView = (ImageView) linearLayout.getChildAt(0);
            catTextView = (TextView)linearLayout.getChildAt(1);

        }

        catImageView.setImageResource(cats[position]);
        catTextView.setText(items.get(position));

        return linearLayout;
    }


}
