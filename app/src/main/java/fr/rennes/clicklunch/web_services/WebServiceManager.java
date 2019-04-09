package fr.rennes.clicklunch.web_services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import fr.rennes.clicklunch.utils.AppUtils;

/**
 * Web service Manager.
 */
public class WebServiceManager {
    public static final String TAG = "WebServiceManager";
    protected static final WebServiceManager instance = new WebServiceManager();

    public enum WSType
    {
        PUT,
        POST,
        GET,
        DELETE,
        PATCH
    }

    private WebServiceManager() {}

    public static WebServiceManager getInstance()
    {
        Log.i(TAG,"Get instance of WebServiceManager.");
        return instance;
    }

    public static AsyncHttpClient getClient()
    {
        return new AsyncHttpClient();
    }

    public static boolean isConnect(Context context)
    {
        boolean result = false;

        Log.i(TAG,"Check if webservice is connect.");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null)
        {
            result = networkInfo.isConnected();
        }

        return result;
    }

    public static void callWS(WSType type, String route, RequestParams requestParams) {
        String finalRoute = AppUtils.APIROOTE + route;
//        requestParams.put(requestParams, "1234");

        if (type == WSType.POST) {
            post(requestParams, finalRoute);
        } else if (type == WSType.GET) {
            get(requestParams, finalRoute);
        } else if (type == WSType.PUT) {
            put(requestParams, finalRoute);
        } else if (type == WSType.DELETE) {
            delete(requestParams, finalRoute);
        }
    }

    private static void post(RequestParams requestParams, String route)
    {
        getClient().post(route, requestParams, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);
                try
                {
                    JSONObject jsonObject = new JSONObject(retour);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(TAG, error.toString());
            }
        });

    }

    private static void put(RequestParams requestParams, String route) {
        getClient().put(route, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(retour);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(TAG, error.toString());
            }
        });
    }

    private static void get(RequestParams requestParams, String route) {
        getClient().get(route, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(retour);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(TAG, error.toString());
            }
        });
    }

    private static void delete(RequestParams requestParams, String route) {
        getClient().get(route, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(retour);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(TAG, error.toString());
            }
        });
    }
}
