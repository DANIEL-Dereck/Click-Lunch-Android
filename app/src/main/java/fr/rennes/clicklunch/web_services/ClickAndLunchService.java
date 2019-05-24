package fr.rennes.clicklunch.web_services;

import java.util.List;

import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.entities.Shop;
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
