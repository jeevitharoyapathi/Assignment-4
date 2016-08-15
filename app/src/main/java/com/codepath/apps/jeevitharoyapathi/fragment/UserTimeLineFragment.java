package com.codepath.apps.jeevitharoyapathi.fragment;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.jeevitharoyapathi.activities.ProfileActivity;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class UserTimeLineFragment extends TweetsListFragment {
    private String mScreenName;
    TwitterClient client;

    public static UserTimeLineFragment newInstance(String screenName) {
        Bundle args = new Bundle();
        args.putString(ProfileActivity.SCREEN_NAME, screenName);
        UserTimeLineFragment fragment = new UserTimeLineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        mScreenName = getArguments().getString(ProfileActivity.SCREEN_NAME);
    }

    protected void populateTimeline() {
        client.getUserTimeline(getLastestTweet(),mScreenName,new JsonHttpResponseHandler() {
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
