package com.jungleworks.classstudents;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jungleworks.adapter.MyAdapter;

public class PagerFragment extends Fragment {
    private View view;
    private ViewPager vpClass2;
    private TabLayout tlStudents;
    private MyAdapter mAdapter;
    public PagerFragment(){ }

//    public static PagerFragment newInstance(String param1, String param2) {
//        PagerFragment fragment2 = new PagerFragment();
//        return fragment2;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_viewpager, container, false);
        vpClass2=view.findViewById(R.id.vpClass2);
        tlStudents=view.findViewById(R.id.tlStudents);
        mAdapter=new MyAdapter(getChildFragmentManager());
        vpClass2.setAdapter(mAdapter);
        tlStudents.setupWithViewPager(vpClass2);
        return view;
    }
    public String getPos(){
        return (String) mAdapter.getPageTitle(tlStudents.getSelectedTabPosition());
    }
    @Override
    public void onStart(){
        super.onStart();

    }

}
