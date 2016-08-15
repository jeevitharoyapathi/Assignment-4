package com.codepath.apps.jeevitharoyapathi.fragment;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class HomeTimeLineFragment extends TweetsListFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    TwitterClient client;

    public static HomeTimeLineFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomeTimeLineFragment fragment = new HomeTimeLineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        mPage = getArguments().getInt(ARG_PAGE);
    }

    protected void populateTimeline() {
        client.getUserTimeline(getLastestTweet(),null,new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                addAll(Tweet.fromJsonArray(response));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject erroResponse) {
                Log.e("jeevitha", erroResponse.toString());
            }
        });
    }

}
