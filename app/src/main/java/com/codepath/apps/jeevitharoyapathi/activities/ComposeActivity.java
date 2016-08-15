package com.codepath.apps.jeevitharoyapathi.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.databinding.ActivityComposeBinding;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.codepath.apps.jeevitharoyapathi.utils.TweetListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class ComposeActivity extends AppCompatActivity {
    @BindView(R.id.NewTweet)
    EditText mBody;
    @BindView(R.id.remainingCount)
    TextView mCount;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btnSubmit)
    Button mSubmit;
    @BindView(R.id.btnCancel)
    Button mCancel;

    private ActivityComposeBinding binding;
    private TweetListener mNewTweet = new TweetListener();
    private TwitterClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_compose);
        binding.setTweet(mNewTweet);
        ButterKnife.bind(this);
        mClient = TwitterApplication.getRestClient();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Compose Tweet");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mSubmit.setOnClickListener(v -> {
            if (!mNewTweet.isEmpty()) {
                postTweet();
            }
        });
        mCancel.setOnClickListener(v -> {
            sendResult(null);
        });
    }

    private void postTweet() {
        mClient.postTweet(mNewTweet.text.get(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                Tweet tweet = Tweet.fromJSON(jsonObject);
                sendResult(tweet);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("jeevitha", throwable.getMessage());
                super.onFailure(statusCode, headers, responseString, throwable);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.e("jeevitha", throwable.getMessage());
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.e("jeevitha", throwable.getMessage());
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    private void sendResult(Tweet tweet) {
        Intent resultIntent = new Intent();
        if (tweet != null) {
            resultIntent.putExtra(TimelineActivity.NEW_TWEET_KEY, Parcels.wrap(tweet));
        }
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
