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

public class MentionsTimeLineFragment extends TweetsListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TwitterClient client;
    // TODO: Rename and change types of parameters
    private int mParam1;



    public static MentionsTimeLineFragment newInstance(int param1) {
        MentionsTimeLineFragment fragment = new MentionsTimeLineFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }


    @Override
    protected void populateTimeline() {
        client.getMentionsTimeLine(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.e("jeevitha", "onSuccess Mentions");
                addAll(Tweet.fromJsonArray(response));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject erroResponse) {
                Log.e("jeevitha", erroResponse.toString());
            }
        },getLastestTweet());
    }
}
