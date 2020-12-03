package com.example.mobilemanagerassistant.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilemanagerassistant.R;
import com.example.mobilemanagerassistant.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    private static final int PROJECT_ACTIVITY_REQUEST_CODE = 333;
    private DashboardFragmentClickHandlers dashboardFragmentClickHandlers;
    private FragmentDashboardBinding fragmentDashboardBinding;

    public DashboardFragment() {
    }


    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashboardFragmentClickHandlers = new DashboardFragmentClickHandlers();
        fragmentDashboardBinding.setClickHandlers(dashboardFragmentClickHandlers);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding fragmentDashboardBinding =
                FragmentDashboardBinding.inflate(inflater, container, false);
        return fragmentDashboardBinding.getRoot();
    }

    public class DashboardFragmentClickHandlers {

        public void onOpenProjectPageClickHandlers () {
            Intent intent = new Intent(getContext(), ProjectActivity.class);
            startActivityForResult(intent, PROJECT_ACTIVITY_REQUEST_CODE);
        }
    }
}