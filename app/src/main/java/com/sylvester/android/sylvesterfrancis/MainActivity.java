package com.sylvester.android.sylvesterfrancis;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.sylvester.android.sylvesterfrancis.activities.DrawerActivity;
import com.sylvester.android.sylvesterfrancis.fragment.AboutMeFragment;
import com.sylvester.android.sylvesterfrancis.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sylvester on 30/07/17.
 */

public class MainActivity extends DrawerActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);

        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        AboutMeFragment about = new AboutMeFragment();
                        return about;
                    //case 1:
                    //    return RecyclerViewFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    //case 3:
                    //    return WebViewFragment.newInstance();

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
                        return "About Me";
                    case 1:
                        return "Certificates";
                    case 2:
                        return "Projects";
                    case 3:
                        return "Contact me";
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
}
