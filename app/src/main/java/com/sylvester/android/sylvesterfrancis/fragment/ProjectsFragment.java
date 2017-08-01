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
import com.sylvester.android.sylvesterfrancis.adapters.ProjectViewAdapter;
import com.sylvester.android.sylvesterfrancis.data.Project;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sylvester on 30/07/17.
 */

public class ProjectsFragment extends Fragment {


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

        final List<Project> projects = new ArrayList<>();
        projects.add(new Project("SmarterPing — Android/Web application:","\n 1.  An On-the go tracking application used to track the position of delivery trucks.\n 2.  Used by Sathya Agencies to track various parameters like current speed,\n position,idling time of their delivery trucks.\n 3.  Allows the firm to maintain good customer relations by predicting the estimated time of delivery of their goods."));
        projects.add(new Project("Mobile Recommender System — Web application:","\n 1. A Novel Recommendation engine which takes in the specifications of mobile phones and matches it with reviews \n 2. Reviews of the various mobile phones were collected by scraping data from various review websites. \n 3.  It performs sentiment analysis on the reviews and suggests a mobile phone suitable for the user. "));
        projects.add(new Project("Rework Flow-Traceability System —Web application:","\n 1. A Process Tracking MEAN Stack Application used to keep track of the process workflow within an Automobile parts manufacturing firm.\n 2. Required creation of a role based authentication system for Rework Flow Tracking Activities performed at the plant. \n 3. Used by their Chennai plant to generate reports based on their day to day activities at the production line"));
        projects.add(new Project("Title 4","Description 4"));
        projects.add(new Project("Title 5","Description 5"));
        projects.add(new Project("Title 6","Description 6"));
        projects.add(new Project("Title 7","Description 7"));
        projects.add(new Project("Title 8","Description 8"));
        projects.add(new Project("Title 9","Description 9"));
        projects.add(new Project("Title 10","Description 10"));
        projects.add(new Project("Title 11","Description 11"));
        projects.add(new Project("Title 12","Description 12"));
        projects.add(new Project("Title 13","Description 13"));
        projects.add(new Project("Title 14","Description 14"));
        projects.add(new Project("Title 15","Description 15"));
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
        mRecyclerView.setAdapter(new ProjectViewAdapter(projects));
    }
}