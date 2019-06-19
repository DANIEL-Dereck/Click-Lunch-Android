/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services;

import java.util.List;

import fr.rennes.clicklunch.entities.Client;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.web_services.ws_entity.Login;
import fr.rennes.clicklunch.web_services.ws_entity.ShopList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClickAndLunchService {

    @GET("shops/p/{numPage}")
    Call<ShopList> listShop(@Path("numPage") int numPage);

    @GET("shops?name={search}")
    Call<ShopList> SearchListShop(@Path("search") String search);

    @GET("shops/{shopId}/products")
    Call<List<Product>> listProduct(@Path("shopId") int shopId);

    @POST("customers")
    Call<Client> addUser(@Body Client client);

    @POST("auth/login")
    Call<Login> login(@Body Login login);


}
