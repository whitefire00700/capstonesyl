package com.sylvester.android.sylvesterfrancis.activities;

/**
 * Created by sylvester on 27/07/17.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.sylvester.android.sylvesterfrancis.BuildConfig;
import com.sylvester.android.sylvesterfrancis.R;

import io.fabric.sdk.android.Fabric;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    //private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(false);
        }
    }

}
