package com.example.Covid19.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kasuscovid_19.R;
import com.example.Covid19.adapter.KasusHarianAdapter;
import com.example.Covid19.model.kasus_harian.KasusHarianDataItem;
import com.example.Covid19.view.viewmodel.KasusHarianViewModel;

import java.util.ArrayList;

public class KasusHarianFragment extends Fragment {

    private KasusHarianAdapter kasusHarianAdapter;
    private RecyclerView rvKasusHarian;
    private KasusHarianViewModel kasusHarianViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kasusHarianAdapter = new KasusHarianAdapter(getContext());
        kasusHarianAdapter.notifyDataSetChanged();

        rvKasusHarian = view.findViewById(R.id.kasusharian_rv_main);
        rvKasusHarian.setLayoutManager(new LinearLayoutManager(getContext()));

        kasusHarianViewModel = new ViewModelProvider(this).get(KasusHarianViewModel.class);
        kasusHarianViewModel.setKasusHarianDiscover();
        kasusHarianViewModel.getKasusHarianDiscover().observe(getViewLifecycleOwner() ,getKasusHarianDiscover);

        rvKasusHarian.setAdapter(kasusHarianAdapter);
    }

    private Observer<ArrayList<KasusHarianDataItem>> getKasusHarianDiscover = new Observer<ArrayList<KasusHarianDataItem>>() {
        @Override
        public void onChanged(ArrayList<KasusHarianDataItem> kasusHarianDataItems) {
            if(kasusHarianDataItems != null){
                kasusHarianAdapter.setData(kasusHarianDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_harian, container, false);
    }

}