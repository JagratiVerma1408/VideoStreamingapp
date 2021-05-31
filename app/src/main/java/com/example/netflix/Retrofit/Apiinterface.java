package com.example.netflix.Retrofit;

import com.example.netflix.Model.AllCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apiinterface {
    @GET("{categoryId}/all_movies.json")
    Observable<List<AllCategory>> getAllCategoryMovies(@Path("categoryId") int categoryId);
}
