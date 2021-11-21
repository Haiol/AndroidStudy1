package com.lovehp30.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lovehp30.myapplication.sax.Weather;

import java.util.ArrayList;

public class ViewAdapter extends FragmentStateAdapter {
    ArrayList<Weather> today,tomo,nTomo;

    public ViewAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Weather> today,ArrayList<Weather> tomo,ArrayList<Weather> nTomo) {
        super(fragmentActivity);
        this.today = today;
        this.tomo = tomo;
        this.nTomo = nTomo;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new cwFragment().newInstance(today);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
