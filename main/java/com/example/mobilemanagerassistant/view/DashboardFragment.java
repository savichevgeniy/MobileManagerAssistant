package com.example.mobilemanagerassistant.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilemanagerassistant.databinding.FragmentDashboardBinding;


public class DashboardFragment extends Fragment {

    public DashboardFragment() {
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding fragmentDashboardBinding =
                FragmentDashboardBinding.inflate(inflater, container, false);
        return fragmentDashboardBinding.getRoot();
    }
}