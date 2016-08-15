package com.codepath.apps.jeevitharoyapathi.fragment;

import android.os.Bundle;

import com.codepath.apps.jeevitharoyapathi.activities.ProfileActivity;
import com.codepath.apps.jeevitharoyapathi.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class FriendsFragment extends UserFragment {

    public static FriendsFragment newInstance(String screenName) {
        Bundle args = new Bundle();
        args.putString(ProfileActivity.SCREEN_NAME, screenName);
        FriendsFragment fragment = new FriendsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void populateTimeline() {
        mClient.getFriends(mScreenName, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                try {
                    mPreviousCursor = jsonObject.getLong("previous_cursor");
                    mNextCursor = jsonObject.getLong("next_cursor");
                    final ArrayList<User> users = User.fromJSON(jsonObject.getJSONArray("users"));
                    addAll(users);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }
}
