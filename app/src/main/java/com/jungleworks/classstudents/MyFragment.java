package com.jungleworks.classstudents;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jungleworks.adapter.StudentJSON;


public class MyFragment extends Fragment {

    private EditText etName, etAge, etRoll;
    private Spinner etSex;
    private Button btSave;
    OnClickButtonListener mCallBack;
    private StudentJSON studentData;


    public MyFragment() { }

    public interface OnClickButtonListener {
        public void onButtonSave(StudentJSON bean, String position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view, container, false);
        studentData = new StudentJSON();
        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etRoll = view.findViewById(R.id.etRoll);
        etSex = view.findViewById(R.id.etSex);
        btSave = view.findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PagerFragment pf = (PagerFragment) MyFragment.this.getParentFragment();
                studentData.setName(etName.getText().toString());
                studentData.setAge(etAge.getText().toString());
                studentData.setSex(etSex.getSelectedItem().toString());
                studentData.setRoll(etRoll.getText().toString());
                mCallBack.onButtonSave(studentData, pf.getPos());
            }
        });
        return view;
    }

    //onstart code
    @Override
    public void onStart() {
        super.onStart();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (OnClickButtonListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

}
