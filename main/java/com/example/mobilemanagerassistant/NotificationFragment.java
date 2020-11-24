package com.example.mobilemanagerassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilemanagerassistant.databinding.FragmentNotificationBinding;

public class NotificationFragment extends Fragment {

    public NotificationFragment() {
    }

    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentNotificationBinding fragmentNotificationBinding =
                FragmentNotificationBinding.inflate(inflater, container, false);
        return fragmentNotificationBinding.getRoot();
    }
}