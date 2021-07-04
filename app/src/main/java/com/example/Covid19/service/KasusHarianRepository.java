package com.example.Covid19.service;

import com.example.Covid19.model.kasus_harian.KasusHarianResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusHarianRepository {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusHarianResponse> getKasusHarian();

}
