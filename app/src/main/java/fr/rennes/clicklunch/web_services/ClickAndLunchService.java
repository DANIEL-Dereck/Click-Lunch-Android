/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services;

import fr.rennes.clicklunch.web_services.ws_entity.ProductList;
import fr.rennes.clicklunch.web_services.ws_entity.ShopList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClickAndLunchService {

    @GET("shops/p/{numPage}")
    Call<ShopList> listShop(@Path("numPage") int numPage);

    @GET("shops?name={search}")
    Call<ShopList> SearchListShop(@Path("search") String search);

    @GET("shops/{shopId}/products")
    Call<ProductList> listProduct(@Path("shopId") int shopId);
}
