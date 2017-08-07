package com.sylvester.android.sylvesterfrancis.retrofit;

import com.sylvester.android.sylvesterfrancis.data.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sylvester on 05/08/17.
 */

public interface IProject {

    @GET("project.json")
    Call<List<Project>> getProject();
}
