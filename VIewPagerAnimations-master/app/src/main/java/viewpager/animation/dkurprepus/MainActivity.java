package viewpager.animation.dkurprepus;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;

import java.util.ArrayList;
import java.util.List;

import viewpager.animation.dkurprepus.Adapter.CustomPagerAdapter;
/*      Created by dkurprepus     */
public class MainActivity extends AppCompatActivity {

    List<String> pageList;
    ViewPager viewPager;
    CustomPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageList = new ArrayList<>();

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        for (int i = 0; i < 15; i++) {
            pageList.add("Page : " + (i + 1));
        }

        pagerAdapter = new CustomPagerAdapter(this, pageList);
        viewPager.setAdapter(pagerAdapter);

        //this is default viewpager now add some animation to our viewpager by adding toxic Bakery Library

        //now add some constructor for animation like this
        viewPager.setPageTransformer(true, new CubeOutTransformer());
        //you can apply anyone you want lets Run

        //there are Some other animation if you want to apply

        /*   like StackTransformer()
                  RotateDownTransformer()
                  CubeOutTransformer()
                  CubeInTransformer()
                  ZoomInTransformer()
                  ZoomOutTransformer()
                   ZoomOutSlideTransformer()
                   ScaleInOutTransformer()
                   ScaleInOutTransformer()
                   DrawerTransformer()
                   AccordionTransformer()
                   ForegroundToBackgroundTransformer()
                   FlipVerticalTransformer()
                   ABaseTransformer()
                   DepthPageTransformer()
                   RotateUpTransformer()
                   BackgroundToForegroundTransformer()          */

        //we are done thanks for watching Take care


    }
}
