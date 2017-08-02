package com.sylvester.android.sylvesterfrancis.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.sylvester.android.sylvesterfrancis.R;
import com.sylvester.android.sylvesterfrancis.adapters.CertificateViewAdapter;
import com.sylvester.android.sylvesterfrancis.data.Certificate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sylvester on 30/07/17.
 */

public class CertificatesFragment extends Fragment {


    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 1;

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

        final List<Certificate> certificates = new ArrayList<>();
        certificates.add(new Certificate("Machine Learning NanoDegree","Udacity",R.drawable.mlnanodegree));
        certificates.add(new Certificate("CS188.1X Artificial Intelligence","EDX/UC-Berkley",R.drawable.edx_ai));
        certificates.add(new Certificate("Introduction to Meteor Js","Coursera/University of London",R.drawable.meteor));
        certificates.add(new Certificate("Introduction to MongoDB using MeanStack","EDX/MongoDB University",R.drawable.mongodb));
        certificates.add(new Certificate("MongoDB for NodeJs Developers","MongoDB University",R.drawable.mongonodejs));
        certificates.add(new Certificate("Python DataStructures","Coursera/University of Michigan",R.drawable.pythonds));
        certificates.add(new Certificate("RESTful Web Services with Node.js and Express","PluralSight",R.drawable.restful));
        certificates.add(new Certificate("The Complete JavaScript Course for Web Developers","Udemy",R.drawable.js));
        certificates.add(new Certificate("Learn AngularJs Step by Step","Udemy",R.drawable.angularjs));
        certificates.add(new Certificate("ExpressJS Fundamentals","Udemy",R.drawable.expressjs));
        certificates.add(new Certificate("Introduction to Computer Science CS50","EDX/Harvard University",R.drawable.intro));



        /*for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        } */


        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new CertificateViewAdapter(certificates));
    }
}