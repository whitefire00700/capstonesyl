package com.sylvester.android.sylvesterfrancis.retrofit;

import com.sylvester.android.sylvesterfrancis.pojo.Certificate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sylvester on 05/08/17.
 */
public interface ICertificate {

    @GET("certificate.json")
    Call<ArrayList<Certificate>> getCertificate();
}
