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

/**
 * Web service Manager.
 */
public class WebServiceManager {
    public enum WSType
    {
        PUT,
        POST,
        GET,
        DELETE
    }

    public static final String TAG = "WebServiceManager";
    protected static final WebServiceManager instance = new WebServiceManager();
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

        Log.i(TAG,"Check if is connect.");

        // récupération du manager :
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //récupération de l'état de la connexion :
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null)
        {
            result = networkInfo.isConnected();
        }

        return result;
    }

    public static void callWS(WSType type) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("parametre", "1234");

        if (type == WSType.POST)
        {
            post(requestParams);
        }
    }

    private static void post(RequestParams requestParams)
    {
        getClient().post("", requestParams, new AsyncHttpResponseHandler()
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
