package com.sylvester.android.sylvesterfrancis.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sylvester on 05/08/17.
 */

public interface IProject {
    @GET("project.json")
    Call<JSONResponse> getProject();
}
