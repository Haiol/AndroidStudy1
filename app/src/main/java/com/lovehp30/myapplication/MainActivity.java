package com.lovehp30.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lovehp30.myapplication.databinding.ActivityMainBinding;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }




}