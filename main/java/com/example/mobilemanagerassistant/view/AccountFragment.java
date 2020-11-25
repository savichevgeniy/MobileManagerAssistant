package com.example.mobilemanagerassistant.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilemanagerassistant.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    public AccountFragment() {
    }

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAccountBinding fragmentAccountBinding =
                FragmentAccountBinding.inflate(inflater, container, false);
        return fragmentAccountBinding.getRoot();
    }
}