package com.codepath.apps.jeevitharoyapathi.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by jeevitha.royapathi on 8/4/16.
 */
@Parcel
public class User {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("profile_image_url")
    private String profileImageUrl;
    @SerializedName("followers_count")
    private String followers;
    @SerializedName("friends_count")
    private String friendsCount;
    @SerializedName("description")
    private String Tag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFriendsCount() {
        return friendsCount;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public void setFriendsCount(String friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public static User fromJSON(JSONObject jsonObject) {
        User user = new User();
        try {
            user.setName(jsonObject.getString("name"));
            user.setId(jsonObject.getLong("id"));
            user.setScreenName(jsonObject.getString("screen_name"));
            user.setProfileImageUrl(jsonObject.getString("profile_image_url"));
            user.setFollowers(jsonObject.getString("followers_count"));
            user.setFriendsCount(jsonObject.getString("friends_count"));
            user.setTag(jsonObject.getString("description"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;

    }

    public static ArrayList<User> fromJSON(JSONArray jsonArray) {
        ArrayList<User> users = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = null;
            try {
                userJson = jsonArray.getJSONObject(i);
                User user = User.fromJSON(userJson);
                users.add(user);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        return users;
    }
}