package com.lovehp30.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lovehp30.myapplication.databinding.FragmentCwBinding;
import com.lovehp30.myapplication.sax.Weather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class cwFragment extends Fragment {


    private static final String ARG_PARAM2 = "param2";


    private ArrayList<Weather> mParam2;
    private FragmentCwBinding binding;

    public static cwFragment newInstance( ArrayList<Weather> param2) {
        cwFragment fragment = new cwFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = (ArrayList<Weather>) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCwBinding.inflate(getLayoutInflater());
        binding.text2.setText("씨이발");

        View v =binding.getRoot();



        return v;
    }
}