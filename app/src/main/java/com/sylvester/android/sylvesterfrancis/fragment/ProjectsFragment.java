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
        projects.add(new Project("SmarterPing — Android/Web application:","\n 1.  An On-the go tracking application used to track the position of delivery trucks.\n 2.  Used by Sathya Agencies to track various parameters like current speed, position,idling time of their delivery trucks.\n 3.  Allows the firm to maintain good customer relations by predicting the estimated time of delivery of their goods."));
        projects.add(new Project("Mobile Recommender System — Web application:","\n 1. A Novel Recommendation engine which takes in the specifications of mobile phones and matches it with reviews \n 2. Reviews of the various mobile phones were collected by scraping data from various review websites. \n 3.  It performs sentiment analysis on the reviews and suggests a mobile phone suitable for the user. "));
        projects.add(new Project("Rework Flow-Traceability System —Web application:","\n 1. A Process Tracking MEAN Stack Application used to keep track of the process workflow within an Automobile parts manufacturing firm.\n 2. Required creation of a role based authentication system for Rework Flow Tracking Activities performed at the plant. \n 3. Used by their Chennai plant to generate reports based on their day to day activities at the production line"));
        projects.add(new Project("Spam Detection using Naive Bayes and Support Vector Machines:","\n 1.  The Project involves classifying the SMS messages received in an end-user's phone as either a Spam message or Ham message\n 2. This project was submitted as part of Udacity\'s Machine Learning Nanodegree Program \n 3.Made a performance comparison between the Naive Bayes Algorithm and Support Vector Machines with TF-IDF Algorithm"));
        projects.add(new Project("Predicting Boston Housing Prices:","\n 1. Built a model to predict the value of a given house in the Boston real estate market using various statistical analysis tools \n 2. Identified the best price that a client can sell their house utilizing machine learning. \n 3. Part of the Machine Learning Engineer Nanodegree Program"));
        projects.add(new Project("Building a Student Intervention System:","\n 1. Investigated the factors that affect a student's performance in high school. \n 2. Trained and tested several supervised machine learning models on a given dataset to predict how likely a student is to pass. \n 3. Selected the best model based on relative accuracy and efficiency. \n Part of the Machine Learning Engineer Nanodegree Program "));
        projects.add(new Project("Creating Customer Segments:"," \n 1. Reviewed unstructured data to understand the patterns and natural categories that the data fits into. \n 2. Used multiple algorithms and both empirically and theoretically compared and contrasted their results. \n 3. Made predictions about the natural categories of multiple types in a dataset, then checked these predictions against the result of unsupervised analysis \n Part of the Machine Learning Engineer Nanodegree Program"));
        projects.add(new Project("Train a Smartcab to Drive:","\n 1. Applied reinforcement learning to build a simulated vehicle navigation agent. \n 2. Involved modeling a complex control problem in terms of limited available inputs, and designing a scheme to automatically learn an optimal driving strategy based on rewards and penalties. \n 3. Part of the Machine Learning Engineer Nanodegree Program"));
        projects.add(new Project("Popular Movies, Stage 1:" ,"\n 1. Built an app to help users discover popular and highly rated movies on the web. \n 2. It displays a scrolling grid of movie trailers and launches a details screen whenever a particular movie is selected \n 3. This app utilizes core Android user interface components and fetches movie information using themoviedb.org web API. \n Part of the Android Developer Nanodegree Program "));
        projects.add(new Project("Popular Movies, Stage 2:","\n 1. Built an app, optimized for tablets, to help users discover popular and highly rated movies on the web. \n 2. It displays a scrolling grid of movie trailers, launches a details screen whenever a particular movie is selected, \n allows users to save favorites, play trailers, and read user reviews. \n 3. This app utilizes core Android user interface components and fetches movie information using themoviedb.org web API.\n Part of the Android Developer Nanodegree Program" ));
        projects.add(new Project("Build It Bigger:","\n 1. Used Gradle to build a joke-telling app that has both a free and paid version. \n 2. This included factoring functionality into libraries as well as using build flavors to modularize the construction of each variant of the app \n 3. Configured a Google Cloud Endpoints development server to supply the jokes. \n Part of the Android Developer Nanodegree Program"));
        projects.add(new Project("Make Your App Material:","\n 1. Transformed the user experience of a news reading app using Material Design principles. \n 2. This includes consistent and meaningful use of Material Design UI components, fonts, color, motion and surfaces. \n 3. Part of the Android Developer Nanodegree Program"));
        projects.add(new Project("Baking App:"," \n 1. Created an Android Baking App that will allow resident baker-in-chief, Miriam, to share her recipes with the world \n 2.Created an app that will allow a user to select a recipe and see video-guided steps for how to complete it. \n 3. Part of the Android Developer Nanodegree Program"));
        projects.add(new Project("Portfolio Website:","\n 1. Created www.sylvesterranjithfrancis.com as a personal portfolio-site \n 2. Used material design principles to design the user interface \n 3. Created this website as a hobby project"));
        projects.add(new Project("Portfolio App:","\n 1.Created an Android app as a personal portfolio app \n 2.Used Retrofit and Glide libraries for Http requests and image caching \n 3. Created this app as a submission for Android Developer Nanodegree"));
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