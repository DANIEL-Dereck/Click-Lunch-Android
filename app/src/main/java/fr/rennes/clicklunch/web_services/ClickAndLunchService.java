/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services;

import java.util.List;

import fr.rennes.clicklunch.entities.Client;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.web_services.ws_entity.Login;
import fr.rennes.clicklunch.web_services.ws_entity.RetrofitOrder;
import fr.rennes.clicklunch.web_services.ws_entity.ShopList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClickAndLunchService {

    /**
     * Call API to get all shop.
     * @param numPage page number.
     * @return List od shop.
     */
    @GET("shops/p/{numPage}")
    Call<ShopList> listShop(@Path("numPage") int numPage);

    /**
     * Call API to get all shop with name like search.
     * @param search something to search.
     * @return List of shop.
     */
    @GET("shops?name={search}")
    Call<ShopList> SearchListShop(@Path("search") String search);

    /**
     * Call API to get all shop's products
     * @param shopId shop is.
     * @return List of product.
     */
    @GET("shops/{shopId}/products")
    Call<List<Product>> listProduct(@Path("shopId") int shopId);

    /**
     * Call API to create an account.
     * @param client User information.
     * @return client create.
     */
    @POST("customers")
    Call<Client> addUser(@Body Client client);

    /**
     * Call API to log-in.
     * @param login user information.
     * @return the user found.
     */
    @POST("auth/login")
    Call<Login> login(@Body Login login);

    /**
     * Call API to pass an order.
     * @param shopId Shop id.
     * @param userId user id.
     * @param order order.
     * @param token x-auth-token.
     * @return the order create.
     */
    @POST("/api/v1/orders/shops/{shopId}/customers/{customerId}")
    Call<RetrofitOrder.RetrofitOrderResult> passOrder(
            @Path("shopId") int shopId,
            @Path("customerId") int userId,
            @Body RetrofitOrder order,
            @Header("x-auth-token") String token
    );
}
