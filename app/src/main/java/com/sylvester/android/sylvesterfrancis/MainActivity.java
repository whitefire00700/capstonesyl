package com.sylvester.android.sylvesterfrancis;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
    String tab1,tab2,tab3,tab4,errormsg1,errormsg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);
        progressRelativeLayout = (ProgressFrameLayout) findViewById(R.id.progress);
        tab1 = getString(R.string.tab1);
        tab2 = getString(R.string.tab2);
        tab3= getString(R.string.tab3);
        tab4= getString(R.string.tab4);
        errormsg1=getString(R.string.error_line1);
        errormsg2=getString(R.string.error_line2);
        if(isDataConnectionAvailable(this) == true) {
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
            progressRelativeLayout.showEmpty(R.drawable.ic_no_connection_24dp_white, errormsg2,errormsg1
                    );
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
                switch (position % 4) {
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
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return tab1;
                    case 1:
                        return tab2;
                    case 2:
                        return tab3;
                    case 3:
                        return tab4;
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                String image_url = "http://imgur.com/f3ca10a";
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                image_url);
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                image_url);
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                image_url);
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.navigationBarColor,
                                image_url);

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

                }
            });
        }
    }

    public static boolean isDataConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


}



