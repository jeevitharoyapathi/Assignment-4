package com.codepath.apps.jeevitharoyapathi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.adapters.TweetsAdapter;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.codepath.apps.jeevitharoyapathi.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class TweetsListFragment extends Fragment {

    @BindView(R.id.rvResult)
    RecyclerView mRecyclerView;
    private TwitterClient client;
    private ArrayList<Tweet> mTweets;
    private TweetsAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_time_line, container, false);
        ButterKnife.bind(this, view);
        configureRecycleView(view);
        return view;
    }

    private void configureRecycleView(View view) {
        mTweets = new ArrayList<>();
        client = TwitterApplication.getRestClient();
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.referesh_tweets);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTweets.clear();
                populateTimeline();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mAdapter = new TweetsAdapter(getActivity(), mTweets);
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mEndlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                populateTimeline();
            }
        };
        mRecyclerView.addOnScrollListener(mEndlessRecyclerViewScrollListener);
        populateTimeline();
    }

    protected abstract void populateTimeline();

    public void addAll(List<Tweet> tweets)
    {
        mTweets.addAll(tweets);
        mAdapter.notifyDataSetChanged();
    }

    public String getLastestTweet()
    {
       return mAdapter.getLastTweetId();
    }
}