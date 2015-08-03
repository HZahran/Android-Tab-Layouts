package com.hishamzahran.tabs2;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.TabLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private static final int TABS = 3;
    private static ArrayList<String> lists[] = new ArrayList[TABS];
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vpPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(myPagerAdapter);

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
//        tabLayout.setMinimumWidth(getResources().getDisplayMetrics().widthPixels);
//        tabLayout.setupWithViewPager(viewPager);

//        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
//        tabsStrip.setViewPager(viewPager);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        for (int i = 0; i < TABS; i++)
            lists[i] = new ArrayList<String>();

    }

    public void addItem(View v) {
        int page = viewPager.getCurrentItem();
//        MyFragment frag = myPagerAdapter.getItem(page);
//        frag.updateList();

        lists[page].add("Ahmed-011123214");
        myPagerAdapter.notifyDataSetChanged();

    }

    public void removeItem(View v) {
        int page = viewPager.getCurrentItem();
        lists[page].remove("Ahmed-011123214");
        viewPager.getAdapter().notifyDataSetChanged();
    }







    static class MyPagerAdapter extends FragmentPagerAdapter implements SmartTabLayout.TabProvider {
        //implements PagerSlidingTabStrip.IconTabProvider{

        private Context context;
        private String[] tabs = {"All", "Fav", "Block"};
        private int images[] = {
                R.drawable.call,
                R.drawable.fav,
                R.drawable.block,
        };


        public MyPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public MyFragment getItem(int position) {
            return MyFragment.getInstance(lists[position]);
        }


        @Override
        public CharSequence getPageTitle(int position) {

            Drawable image = ContextCompat.getDrawable(context, images[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            SpannableString sb = new SpannableString("  \n" + tabs[position]);
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            return sb;
        }

        @Override
        public int getCount() {
            return TABS;
        }

        @Override
        public View createTabView(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter) {

            return null;
        }

        //        @Override
//        public int getPageIconResId(int i) {
//            return images[i];
//        }
    }

}
