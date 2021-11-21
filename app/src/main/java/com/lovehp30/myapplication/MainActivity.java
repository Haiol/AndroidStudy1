package com.lovehp30.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.lovehp30.myapplication.databinding.ActivityMainBinding;
import com.lovehp30.myapplication.sax.SAXHandler;
import com.lovehp30.myapplication.sax.Weather;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4136025000
    private ArrayList<Weather> today,tomo,nTomo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
        urlParser();
    }


    private void urlParser() {
        try {
            URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4136025000"); //기사청 날씨 URL
            InputStream inputStream = url.openStream();
            SAXParserFactory factory = SAXParserFactory.newInstance(); //공장 패턴
            SAXParser parser = factory.newSAXParser(); //SAXParse 얻어냄.
            SAXHandler handler = new SAXHandler();
            parser.parse(inputStream,handler);
            List<Weather> list = handler.getWeatherList();
            String s = "";
//            for (Weather w : list)
//                s += w.getAll() + "\n";
//            Log.e("Xml02", s);
            today = new ArrayList<>();
            tomo = new ArrayList<>();
            nTomo = new ArrayList<>();
            for(Weather w:list){
                switch (w.getDays()){
                   case 0: today.add(w);break;
                    case 1: tomo.add(w);break;
                    case 2: nTomo.add(w);break;
                }
            }
            ViewAdapter adapter = new ViewAdapter(this,today,tomo,nTomo);
            binding.Pager.setAdapter(adapter);
        } catch (Exception e) {
            Log.e("Xml02","예외 발생",e);
        }

    }




}