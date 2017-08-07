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
import com.sylvester.android.sylvesterfrancis.adapters.CertificateViewAdapter;
import com.sylvester.android.sylvesterfrancis.retrofit.ICertificate;
import com.sylvester.android.sylvesterfrancis.data.Certificate;

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

/**
 * Created by sylvester on 30/07/17.
 */

public class CertificatesFragment extends Fragment {


    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 1;
    private ArrayList<Certificate> certificates;
    private CertificateViewAdapter adapter;

    @BindView(R.id.recyclerView)
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


        /*for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        } */


        //setup materialviewpager
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

        ICertificate request = retrofit.create(ICertificate.class);
        Call<List<Certificate>> call = request.getCertificate();
        call.enqueue(new Callback<List<Certificate>>() {
            @Override
            public void onResponse(Call<List<Certificate>> call, Response<List<Certificate>> response) {

                List<Certificate> responseBody = response.body();

                certificates = new ArrayList<>(responseBody);
                adapter = new CertificateViewAdapter(certificates);
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
            public void onFailure(Call<List<Certificate>> call, Throwable t) {
                Log.d("Debug", t.getMessage());
            }
        });
    }

}