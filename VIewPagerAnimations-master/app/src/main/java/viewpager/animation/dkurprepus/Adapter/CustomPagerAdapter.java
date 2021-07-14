package viewpager.animation.dkurprepus.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;
import java.util.Random;

import viewpager.animation.dkurprepus.R;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> pageList;

    public CustomPagerAdapter(Context context, List<String> pageList) {
        mContext = context;
        this.pageList = pageList;

    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        final LinearLayout llRow;
        final TextView tvPagetext;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.row_viewpager, collection, false);
        llRow = (LinearLayout) layout.findViewById(R.id.llRow);
        tvPagetext = (TextView) layout.findViewById(R.id.tvPagetext);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        llRow.setBackgroundColor(color);
        tvPagetext.setText(pageList.get(position));

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}