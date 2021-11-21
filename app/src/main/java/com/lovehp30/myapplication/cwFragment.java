package com.lovehp30.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lovehp30.myapplication.databinding.FragmentCwBinding;
import com.lovehp30.myapplication.sax.Weather;

import java.util.ArrayList;


public class cwFragment extends Fragment {


    private static final String ARG_PARAM2 = "param2";

    private String title;
    private ArrayList<Weather> list;
    private FragmentCwBinding binding;
    ArrayList<Txt> txts;

    public static cwFragment newInstance( ArrayList<Weather> param2,String title) {
        cwFragment fragment = new cwFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        args.putSerializable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            list = (ArrayList<Weather>) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCwBinding.inflate(getLayoutInflater());
        binding.title.setText(title);
        setClear();
      
        txts.get(0).temp.setText(list.get(0).getTemp()+" 도");
        txts.get(0).weather.setText(list.get(0).getWfKor());//맑음, 구름 많음, 흐림, 비, 비/눈, 눈, 소나기
     
        for(int i = 1;i<txts.size();i++){
            if(i<list.size()) {
                txts.get(i).title.setText(list.get(i).getHour() + " 시");
                txts.get(i).weather.setText(list.get(i).getWfKor());
                txts.get(i).temp.setText(list.get(i).getTemp() + " 도");
            }else{
                txts.get(i).title.setText("");
                txts.get(i).weather.setText("");
                txts.get(i).temp.setText("");
            }
        }



        View v =binding.getRoot();



        return v;
    }
    void setClear(){
        txts = new ArrayList<>();
        txts.add(new Txt(binding.title,binding.temp,binding.weather));
        txts.add(new Txt(binding.title1,binding.temp1,binding.weather1));
        txts.add(new Txt(binding.title2,binding.temp2,binding.weather2));
        txts.add(new Txt(binding.title3,binding.temp3,binding.weather3));
        txts.add(new Txt(binding.title4,binding.temp4,binding.weather4));
        txts.add(new Txt(binding.title5,binding.temp5,binding.weather5));
        txts.add(new Txt(binding.title6,binding.temp6,binding.weather6));
        txts.add(new Txt(binding.title7,binding.temp7,binding.weather7));
    }
    public class Txt{
        TextView title;
        TextView temp;
        TextView weather;
        Txt(TextView title, TextView temp, TextView weather){
            this.title = title;
            this.temp = temp;
            this.weather = weather;
        }
    }
}