package com.linhdt.helix.flickrsample;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.FlickrApi;

/**
 * Created by DangThanhLinh on 23/05/2017.
 */

class FlickrClient extends OAuthBaseClient {

    public static final Class<? extends Api> REST_API_CLASS = FlickrApi.class;

    public static final String REST_URL = "https://www.flickr.com/services";

    public static final String REST_CONSUMER_KEY = "bc41525818f51cfe58a8688c292df623";

    public static final String REST_CONSUMER_SECRET = "164700acd7a7215a";

    public static final String REST_CALLBACK_URL = "oauth://cprest";

    public FlickrClient(Context c) {
        super(c, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET,
                REST_CALLBACK_URL);
        setBaseUrl("https://api.flickr.com/services/rest");
    }

    public void getInterestingnessList(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("?&format=json&nojsoncallback=1&method=flickr.interestingness.getList");
        Log.d("DEBUG", "Sending API call to " + apiUrl);
        client.get(apiUrl, null, handler);
    }
}
