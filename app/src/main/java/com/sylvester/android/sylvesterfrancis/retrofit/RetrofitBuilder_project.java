package com.sylvester.android.sylvesterfrancis.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sylvester on 05/08/17.
 */

public final class RetrofitBuilder_project {
    static IProject iProject;

    public static IProject Retrieve() {

        Gson gson = new GsonBuilder().create();

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();


        iProject = new Retrofit.Builder()
                .baseUrl("http://sylvester-whitefire00700.rhcloud.com/json/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build().create(IProject.class);

        return iProject;

    }

}
