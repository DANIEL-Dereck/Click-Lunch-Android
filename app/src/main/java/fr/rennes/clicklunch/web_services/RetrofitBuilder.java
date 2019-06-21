/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services;

import fr.rennes.clicklunch.utils.AppUtil;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    public static final String KEY_AUTH_TOKEN = "x-auth-token";

    public static ClickAndLunchService getGsonClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppUtil.APIROOTE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClickAndLunchService webServer = retrofit.create(ClickAndLunchService.class);
        return webServer;
    }

    public static ClickAndLunchService getManuelClient(Converter.Factory converter) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppUtil.APIROOTE)
                .addConverterFactory(converter)
                .build();

        ClickAndLunchService webServer = retrofit.create(ClickAndLunchService.class);
        return webServer;
    }
}
