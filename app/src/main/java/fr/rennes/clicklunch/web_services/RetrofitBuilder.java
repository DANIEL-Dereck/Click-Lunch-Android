package fr.rennes.clicklunch.web_services;

import fr.rennes.clicklunch.utils.AppUtil;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    public static ClickAndLunchService getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppUtil.APIROOTE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClickAndLunchService webServer = retrofit.create(ClickAndLunchService.class);
        return webServer;
    }
}
