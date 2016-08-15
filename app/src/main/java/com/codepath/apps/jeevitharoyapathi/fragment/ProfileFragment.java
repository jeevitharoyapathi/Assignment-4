package com.codepath.apps.jeevitharoyapathi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.models.User;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;


public class ProfileFragment extends Fragment {

    public static final String SCREEN_NAME = "screen_name";
    @BindView(R.id.profile_img)
    ImageView ivProfileImage;
    @BindView(R.id.user_name)
    TextView mName;
    @BindView(R.id.screen_name)
    TextView mScreenName;
    @BindView(R.id.user_tag)
    TextView mUserTag;
    @BindView(R.id.user_following_count)
    TextView mFollowingCount;
    @BindView(R.id.user_following)
    TextView mFollowing;
    @BindView(R.id.user_friends_count)
    TextView mFriendsCount;
    @BindView(R.id.user_friends)
    TextView mFriends;
    private User mUser;
    private TwitterClient mClient = TwitterApplication.getRestClient();

    public static ProfileFragment newInstance(String screenName) {
        Bundle args = new Bundle();
        args.putString(SCREEN_NAME, screenName);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getUserInfo();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_time_line, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void getUserInfo() {
        final String screenName = getArguments().getString(SCREEN_NAME);
        mClient.getUserInfo(screenName, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject object) {
                mUser = User.fromJSON(object);
                Picasso.with(getActivity())
                        .load(mUser.getProfileImageUrl())
                        .into(ivProfileImage);
                mName.setText(mUser.getName());
                mScreenName.setText("@" + mUser.getScreenName());
                mUserTag.setText(mUser.getTag());
                mFollowing.setText("Following");
                mFriends.setText("Followers");
                mFriendsCount.setText(mUser.getFriendsCount());
                mFollowingCount.setText(mUser.getFollowers());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }
}