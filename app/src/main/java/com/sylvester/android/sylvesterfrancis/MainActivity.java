package com.sylvester.android.sylvesterfrancis;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.sylvester.android.sylvesterfrancis.activities.DrawerActivity;
import com.sylvester.android.sylvesterfrancis.fragment.AboutMeFragment;
import com.sylvester.android.sylvesterfrancis.fragment.CertificatesFragment;
import com.sylvester.android.sylvesterfrancis.fragment.ContactMeFragment;
import com.sylvester.android.sylvesterfrancis.fragment.ProjectsFragment;
import com.sylvester.android.sylvesterfrancis.fragment.RecyclerViewFragment;
import com.vlonjatg.progressactivity.ProgressFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sylvester on 30/07/17.
 */

public class MainActivity extends DrawerActivity  {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    ProgressFrameLayout progressRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);
        progressRelativeLayout = (ProgressFrameLayout) findViewById(R.id.progress);
        if(isInternetOn() == true) {
            progressRelativeLayout.showLoading();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressRelativeLayout.showContent();
                }
            }, 4000);
            }
        else {
            progressRelativeLayout.showLoading();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
            progressRelativeLayout.showEmpty(R.drawable.ic_no_connection_24dp_white, "Error No Internet Connection found",
                    "Please switch on Wifi/MobileData to continue.");
                }
            }, 4000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    startActivity(getIntent());
                }
            }, 5000);


        }
        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 5) {
                    case 0:
                        AboutMeFragment about = new AboutMeFragment();
                        return about;
                    case 1:
                        CertificatesFragment certificate = new CertificatesFragment();
                        return certificate;
                    case 2:
                        ProjectsFragment project = new ProjectsFragment();
                        return project;
                    case 3:
                        ContactMeFragment contact = new ContactMeFragment();
                        return contact;
                    case 4:
                        return RecyclerViewFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 5) {
                    case 0:
                        return "About Me";
                    case 1:
                        return "Certificates";
                    case 2:
                        return "Projects";
                    case 3:
                        return "Contact me";
                    case 4:
                        return "Chat";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                "http://imgur.com/f3ca10a");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                "http://imgur.com/f3ca10a");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                "http://imgur.com/f3ca10a");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                "http://imgur.com/f3ca10a");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                "http://imgur.com/f3ca10a");

                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });


        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {


            return false;
        }
        return false;
    }
}



