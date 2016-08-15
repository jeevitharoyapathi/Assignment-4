package com.codepath.apps.jeevitharoyapathi.models;

/**
 * Created by jeevitha.royapathi on 8/4/16.
 */

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Parcel
public class Tweet {

    public static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
    @SerializedName("id")
    private long id;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("text")
    private String text;
    @SerializedName("user")
    private User mUser;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();
        try {
            tweet.setId(jsonObject.getLong("id"));
            tweet.setUser(User.fromJSON(jsonObject.getJSONObject("user")));
            tweet.setText(jsonObject.getString("text"));
            String datestr = jsonObject.getString("created_at");
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            Date createdDate = null;
            try {
                createdDate = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tweet.setCreatedAt(createdDate);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tweet;

    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if (tweet != null) {
                    tweets.add(tweet);
                }
            } catch (Exception e) {
            }
        }
        return tweets;
    }
}