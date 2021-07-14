package com.example.scrolllingimages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SwipeAdapter extends PagerAdapter {

    private int img[]={R.drawable.android1,R.drawable.auto4,R.drawable.android2,R.drawable.android3,R.drawable.android6};
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeAdapter(Context context)
    {
this.context=context;
    }

    @Override
    public int getCount() {

        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return (view==object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView)itemview.findViewById(R.id.image_view);
        imageView.setImageResource(img[position]);
        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
container.removeView((LinearLayout)object);
    }
}
