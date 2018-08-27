package com.jungleworks.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.jungleworks.classstudents.PagerFragment;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter2 extends FragmentPagerAdapter {
    public final List<String> mTitleList=new ArrayList<>();


    public MyAdapter2(FragmentManager fragmentManager){
        super(fragmentManager);
        mTitleList.add("CLASS 1");
        mTitleList.add("CLASS 2");
        mTitleList.add("CLASS 3");
        mTitleList.add("CLASS 4");
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return new PagerFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
