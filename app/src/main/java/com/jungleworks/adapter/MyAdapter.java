package com.jungleworks.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jungleworks.classstudents.MyFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {
    public final List<String> mTitleList=new ArrayList<>();


    public MyAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        String[] i={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        mTitleList.addAll(Arrays.asList(i));
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return new MyFragment();
    }

    @Override
    public int getCount() {
        return 20;
    }
}
