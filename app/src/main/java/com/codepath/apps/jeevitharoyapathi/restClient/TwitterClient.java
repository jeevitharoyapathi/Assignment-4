package com.codepath.apps.jeevitharoyapathi.restClient;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
    public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
    public static final String REST_CONSUMER_KEY = "wfk5GsAFOQ3JLClRFkCr6lYK9";       // Change this
    public static final String REST_CONSUMER_SECRET = "MhdqwN2SYfTe82zmn8OXDnvyFIadEyQ1WcvsQy1MRe3UmvtSK2"; // Change this
    public static final String REST_CALLBACK_URL = "oauth://cptwitter"; // Change this (here and in manifest)

    public TwitterClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }

    public void getHomeTimeline(AsyncHttpResponseHandler handler, String max_id) {
        String apiUrl = getApiUrl("/statuses/home_timeline.json");
        // Since_ID = since_id + count;
        RequestParams params = new RequestParams();
        params.put("count", 45);
        if (max_id != null) {
            params.put("max_id", max_id);
        }
        client.get(apiUrl, params, handler);
    }

    public void postTweet(String body, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/update.json");
        RequestParams params = new RequestParams();
        params.put("status", body);
        client.post(apiUrl, params, handler);
    }

    public void getCurrentUser(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("account/verify_credentials.json");
        getClient().get(apiUrl, handler);
    }

    public void getMentionsTimeLine(AsyncHttpResponseHandler handler, String max_id) {
        String apiUrl = getApiUrl("statuses/mentions_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", 45);
        if (max_id != null) {
            params.put("max_id", max_id);
        }
        getClient().get(apiUrl, params, handler);
    }

    public void getUserTimeline(String max_id,String screenName, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/user_timeline.json");
        RequestParams params = new RequestParams();
        params.put("screen_name", screenName);
        if(max_id != null){
            params.put("max_id", max_id);
        }
        params.put("count", 45);
        getClient().get(apiUrl, params, handler);
    }

    public void getUserInfo(String screenName,AsyncHttpResponseHandler handler){
        String apiUrl = getApiUrl("users/show.json");
        RequestParams params = new RequestParams();
        params.put("screen_name", screenName);
        getClient().get(apiUrl, params, handler);
    }

    public void getFriends(String screenName, Long cursor, AsyncHttpResponseHandler handler){
        String apiUrl = getApiUrl("friends/list.json");
        RequestParams params = new RequestParams();
        params.put("screen_name", screenName);
        params.put("cursor", cursor);
        getClient().get(apiUrl, params, handler);
    }

    public void getFollowers(String screenName, Long cursor, AsyncHttpResponseHandler handler){
        String apiUrl = getApiUrl("followers/list.json");
        RequestParams params = new RequestParams();
        params.put("screen_name", screenName);
        params.put("cursor", cursor);
        getClient().get(apiUrl, params, handler);
    }

}