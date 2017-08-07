package com.sylvester.android.sylvesterfrancis.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.sylvester.android.sylvesterfrancis.R;
import com.sylvester.android.sylvesterfrancis.adapters.ProjectViewAdapter;
import com.sylvester.android.sylvesterfrancis.retrofit.IProject;
import com.sylvester.android.sylvesterfrancis.retrofit.JSONResponse_Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sylvester.android.sylvesterfrancis.R.id.recyclerView;

/**
 * Created by sylvester on 30/07/17.
 */

public class ProjectsFragment extends Fragment {


    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 1;
    private ArrayList<JSONResponse_Project> projects;
    private ProjectViewAdapter adapter;

    @BindView(recyclerView)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loadJSON();
    }

    private void loadJSON(){
        Log.d("Debug","Loading the json file");
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.networkInterceptors().add(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Log.d("Debug"," Sending Request " + request.url().toString());
                        okhttp3.Response response = chain.proceed(request);
                        Log.d("Debug"," Receiving Response  " + response.code());
                        return response;
                    }
                });



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sylvester-whitefire00700.rhcloud.com/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        IProject request = retrofit.create(IProject.class);
        Call<List<JSONResponse_Project>> call = request.getProject();
        call.enqueue(new Callback<List<JSONResponse_Project>>() {
            @Override
            public void onResponse(Call<List<JSONResponse_Project>> call, Response<List<JSONResponse_Project>> response) {

                List<JSONResponse_Project> responseBody = response.body();

               projects = new ArrayList<>(responseBody);
                adapter = new ProjectViewAdapter(projects);
                if (GRID_LAYOUT) {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                } else {
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
                mRecyclerView.setHasFixedSize(true);

                //Use this now
                mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<JSONResponse_Project>> call, Throwable t) {
                Log.d("Debug", t.getMessage());
            }
        });
    }

}
