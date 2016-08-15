package com.codepath.apps.jeevitharoyapathi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.adapters.TweetsAdapter;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.codepath.apps.jeevitharoyapathi.utils.EndlessRecyclerViewScrollListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {

    public static final int NEW_TWEET_REQUEST = 100;
    public static final String NEW_TWEET_KEY = "key";
    private TwitterClient client;
    private ArrayList<Tweet> mTweets;
    private TweetsAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;
    @BindView(R.id.rvResult)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab_add)
    FloatingActionButton mFavAdd;
    @BindView(R.id.referesh_tweets)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private GoogleApiClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Twitter");
        client = TwitterApplication.getRestClient();
        mTweets = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTweets.clear();
                populateTimeline();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mAdapter = new TweetsAdapter(this, mTweets);
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(this);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NEW_TWEET_REQUEST) {
                Tweet newTweet = Parcels.unwrap(data.getParcelableExtra(NEW_TWEET_KEY));
                if (newTweet != null) {
                    mAdapter.addToFirstPosition(newTweet);
                    mRecyclerView.scrollToPosition(0);
                }
            }
        }
    }

    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                mTweets.addAll(Tweet.fromJsonArray(response));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject erroResponse) {
                Log.e("jeevitha", erroResponse.toString());
            }
        }, mAdapter.getLastTweetId());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_add)
    void createNewTweet() {
        Intent intent = new Intent(this, ComposeActivity.class);
        startActivityForResult(intent, NEW_TWEET_REQUEST);
    }
}
