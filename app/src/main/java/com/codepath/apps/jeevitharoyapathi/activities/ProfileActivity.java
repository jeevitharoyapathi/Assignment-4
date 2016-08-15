package com.codepath.apps.jeevitharoyapathi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.adapters.UserAdapter;
import com.codepath.apps.jeevitharoyapathi.fragment.FollowersFragment;
import com.codepath.apps.jeevitharoyapathi.fragment.FriendsFragment;
import com.codepath.apps.jeevitharoyapathi.fragment.ProfileFragment;
import com.codepath.apps.jeevitharoyapathi.fragment.UserTimeLineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements UserAdapter.OnItemClickListener {

    public static final String SCREEN_NAME = "screen_name";
    Toolbar mToolBar;
    @BindView(R.id.profile_pager)
    ViewPager mPager;
    @BindView(R.id.profile_tab)
    TabLayout mTab;
    private FragmentPagerAdapter mPagerAdapter;
    String mScreenName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        mScreenName = getIntent().getStringExtra(SCREEN_NAME);
        setupToolBar();
        setUpPager();
        ProfileFragment profileHeaderFragment = ProfileFragment.newInstance(mScreenName);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.profile_layout, profileHeaderFragment)
                .commit();
    }

    private void setUpPager() {
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String tabTitles[] = new String[]{"Tweets", "Followers", "Friends"};

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return UserTimeLineFragment.newInstance(mScreenName);
                } else if (position == 2) {
                    return FriendsFragment.newInstance(mScreenName);
                } else if (position == 1) {
                    return FollowersFragment.newInstance(mScreenName);
                }
                return null;
            }

            @Override
            public int getCount() {
                return tabTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }
        };
        mPager.setAdapter(mPagerAdapter);
        mTab.setupWithViewPager(mPager);
    }

    private void setupToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("@" + mScreenName);
    }

    @Override
    public void onItemClick(String screenName) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(ProfileActivity.SCREEN_NAME, screenName);
        startActivity(intent);
        finish();
    }
}