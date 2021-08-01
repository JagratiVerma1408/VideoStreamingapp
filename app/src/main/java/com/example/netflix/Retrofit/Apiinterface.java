package com.example.netflix.Retrofit;

import com.example.netflix.Model.AllCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.example.netflix.Retrofit.RetrofitClient.BASE_URL;

public interface Apiinterface {
    @GET(BASE_URL)
    Observable<List<AllCategory>> getAllCategoryMovies();
}
