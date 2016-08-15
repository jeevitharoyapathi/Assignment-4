package com.codepath.apps.jeevitharoyapathi.fragment;

import android.content.Context;
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
import com.codepath.apps.jeevitharoyapathi.activities.ProfileActivity;
import com.codepath.apps.jeevitharoyapathi.adapters.UserAdapter;
import com.codepath.apps.jeevitharoyapathi.models.User;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.codepath.apps.jeevitharoyapathi.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class UserFragment extends Fragment {

    protected UserAdapter mUserAdapter;
    protected ArrayList<User> mUsers;
    protected TwitterClient mClient = TwitterApplication.getRestClient();
    protected Long mPreviousCursor;
    protected Long mNextCursor;
    protected String mScreenName;
    @BindView(R.id.rvResult)
    RecyclerView mRecyclerView;
    private TwitterClient client;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    UserAdapter.OnItemClickListener mOnItemClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnItemClickListener=(UserAdapter.OnItemClickListener)getActivity();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_time_line, container, false);
        mScreenName=getArguments().getString(ProfileActivity.SCREEN_NAME);
        ButterKnife.bind(this, view);
        configureRecycleView(view);
        return view;
    }

    private void configureRecycleView(View view) {
        mUsers = new ArrayList<>();
        client = TwitterApplication.getRestClient();
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.referesh_tweets);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mUsers.clear();
                populateTimeline();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mUserAdapter = new UserAdapter(getActivity(), mUsers);
        mUserAdapter.setOnClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mUserAdapter);
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

    public void addAll(List<User> users) {
        mUsers.addAll(users);
        mUserAdapter.notifyDataSetChanged();
    }
}
