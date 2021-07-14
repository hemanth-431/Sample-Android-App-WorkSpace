package com.klef.includeklu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class imageadapter5 extends BaseAdapter {
    private Context context;
    public int[] imagearray={R.drawable.pop16,R.drawable.pop17,R.drawable.pop18,R.drawable.pop19,R.drawable.pop20,R.drawable.pop21};

    public imageadapter5(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagearray.length;
    }

    @Override
    public Object getItem(int position) {
        return imagearray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(context);
        imageView.setImageResource(imagearray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(360,370));
        return imageView;
    }
}
