package com.example.netflix.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private  static final String BASE_URL="https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/api/";
    public  static Apiinterface getRetrofitClient(){
        Retrofit.Builder builder=new Retrofit.Builder()
                                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .baseUrl(BASE_URL);
        return builder.build().create(Apiinterface.class);
    }
}
