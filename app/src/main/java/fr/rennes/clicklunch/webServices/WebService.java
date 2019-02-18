package fr.rennes.clicklunch.webServices;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.content.ContentValues.TAG;

public class WebService {

    public static void callWS() {
        // client HTTP :
        AsyncHttpClient client = new AsyncHttpClient();

        // paramètres :
        RequestParams requestParams = new RequestParams();   requestParams.put("parametre", "1234");
        client.post("http://ws.com", requestParams, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                String retour = new String(response);
//                Log.i(TAG, retour);

                // Recupérer un retour ett le mettre en Json
                String retour = new String(responseBody);
                try
                {
                    JSONObject jsonObject = new JSONObject(retour);
                    Log.i(TAG, jsonObject.getString("info"));

                    // Image, regarder lib Picaso
                    Bitmap bitmap = BitmapFactory.decodeByteArray(
                            responseBody,
                            0,
                            responseBody.length);

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
}
