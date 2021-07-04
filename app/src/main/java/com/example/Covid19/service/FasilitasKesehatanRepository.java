package com.example.Covid19.service;

import com.example.Covid19.model.fasilitas_kesehatan.FasilitasKesehatanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FasilitasKesehatanRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<FasilitasKesehatanResponse> getFasilitasKesehatan();
}
