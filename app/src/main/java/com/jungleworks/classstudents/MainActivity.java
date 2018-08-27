package com.jungleworks.classstudents;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.jungleworks.adapter.StudentJSON;
import com.jungleworks.adapter.ClassToJSON;
import com.jungleworks.adapter.MyAdapter2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyFragment.OnClickButtonListener {
    private MyAdapter2 adapter;//private
    private TabLayout tlClass;
    private FloatingActionButton btCheck;
    private ClassToJSON class1,class2,class3,class4;
    ArrayList<ClassToJSON> classData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vpClass=findViewById(R.id.vpClass);
        tlClass=findViewById(R.id.tlClass);
        btCheck=findViewById(R.id.btCheck);
        class1=new ClassToJSON();
        class2=new ClassToJSON();
        class3=new ClassToJSON();
        class4=new ClassToJSON();
        adapter=new MyAdapter2(getSupportFragmentManager());
        vpClass.setAdapter(adapter);
        tlClass.setupWithViewPager(vpClass);

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classData.add(class1);
                classData.add(class2);
                classData.add(class3);
                classData.add(class4);
                Gson gson=new Gson();
                Log.i("FIRST_JSON",gson.toJson(classData));
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    @Override
    public void onButtonSave(StudentJSON studentData, String position) {
        String mTitle= (String) adapter.getPageTitle(tlClass.getSelectedTabPosition());
        if(mTitle.equals("CLASS 1")){
            class1.getCLASS().add(studentData);
        }
        else if(mTitle.equals("CLASS 2")){
            class2.getCLASS().add(studentData);
        }
        else if(mTitle.equals("CLASS 3")){
            class3.getCLASS().add(studentData);
        }
        else {
            class4.getCLASS().add(studentData);
        }

    }

}
