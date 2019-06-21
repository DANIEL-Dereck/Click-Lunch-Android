/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.FoodListAdapter;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.enums.ProductType;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.utils.FoodListItem;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.utils.GPSTracker;
import fr.rennes.clicklunch.web_services.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class ShopDetailActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x30;
    public static final String TAG = "ShopDetailActivity";

    // Extras.
    public static final String EXTRA_SHOP = "EXTRA_SHOP";
    public static final String EXTRA_SHOP_DISTANCE = "EXTRA_SHOP_DISTANCE";

    private Shop currentShop;
    private int distance = 0;
    private boolean inRequest = false;

    private ImageView iv_shop_detail_shop_photo;
    private ImageView iv_shop_detail_shop_cart;
    private TextView tv_shop_detail_shop_addresse;
    private TextView tv_shop_detail_shop_name;
    private TextView tv_shop_detail_shop_distance;
    private RecyclerView rv_shop_detail_food_list;

    public ArrayList<FoodListItem> foodListItems = new ArrayList<>();
    private FoodListAdapter foodListAdapter;

    private void initTmpList() {
        Log.d(TAG, "initTmpList: ");
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.MENU));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.STARTER));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DISH));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DESSERT));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DRINK));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.OTHER));
    }

    private FoodListItem fillList(FoodListItem products, ProductType type) {
        Log.d(TAG, "fillList: ");
        products.setTitle(type);

        for (int i = 0; i < 20; i++) {
            Product product = new Product();
            product.setName(i + "_productName_" + type.toString());
            product.setPrice(20.5);
            product.setDescription(i + "_Product description test_" + type.toString());
            product.setProductType(type);

            if (type == ProductType.MENU) {
                ArrayList<Product> productsMenu = new ArrayList<>();

                productsMenu.add(new Product(i + "Menu Starter Product", 25.5, i + "description menu", null, ProductType.STARTER, null));
                productsMenu.add(new Product(i + "Menu dish Product", 25.5, i + "description menu", null, ProductType.DISH, null));
                productsMenu.add(new Product(i + "Menu dessert Product", 25.5, i + "description menu", null, ProductType.DESSERT, null));
                productsMenu.add(new Product(i + "Menu drink Product", 25.5, i + "description menu", null, ProductType.DRINK, null));
                productsMenu.add(new Product(i + "Menu other Product", 25.5, i + "description menu", null, ProductType.OTHER, null));

                product.setProducts(productsMenu);
            }

            products.addProduct(product);
        }

        return products;
    }

    private void initFoodList() {
        // Init Menu list
        FoodListItem foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.MENU);
        this.foodListItems.add(foodListItems);

        // Init Starter List
        foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.STARTER);
        this.foodListItems.add(foodListItems);

        // Init Dish List
        foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.DISH);
        this.foodListItems.add(foodListItems);

        // Init Dessert List
        foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.DESSERT);
        this.foodListItems.add(foodListItems);

        // Init Drink List
        foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.DRINK);
        this.foodListItems.add(foodListItems);

        // Init Other List
        foodListItems = new FoodListItem();
        foodListItems.setTitle(ProductType.OTHER);
        this.foodListItems.add(foodListItems);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ProductDetailActivity.MY_ACTIVITY_CODE) {
            if (resultCode == RESULT_OK) {
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) ShopDetailActivity.this.findViewById(android.R.id.content)).getChildAt(0);
                Snackbar snackbar = Snackbar.make(viewGroup, R.string.product_added, Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrangeText));
                snackbar.show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (AppUtil.IS_EXIT_FLAG_RAISED) {
            finish();
        }
    }

    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
        this.iv_shop_detail_shop_cart = this.findViewById(R.id.iv_shop_detail_shop_cart);
        this.rv_shop_detail_food_list = this.findViewById(R.id.rv_shop_detail_food_list);
        this.tv_shop_detail_shop_addresse = this.findViewById(R.id.tv_shop_detail_shop_addresse);
        this.iv_shop_detail_shop_photo = this.findViewById(R.id.iv_shop_detail_shop_photo);
        this.tv_shop_detail_shop_name = this.findViewById(R.id.tv_shop_detail_shop_name);
        this.tv_shop_detail_shop_distance = this.findViewById(R.id.tv_shop_detail_shop_distance);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        this.getDataInIntent();
        this.initFoodList();

        if (currentShop != null) {
            this.foodListAdapter = new FoodListAdapter(this.foodListItems, this);
            this.rv_shop_detail_food_list.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            this.rv_shop_detail_food_list.setLayoutManager(layoutManager);
            this.rv_shop_detail_food_list.setAdapter(this.foodListAdapter);

            this.foodListAdapter.notifyDataSetChanged();

            if (!AppUtil.MODE_API) {
                this.initTmpList();
            } else {
                RetrofitBuilder.getGsonClient().listProduct(ShopDetailActivity.this.currentShop.getId()).enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        Log.d(TAG, ShopDetailActivity.TAG + "onResponse: ");

                        System.out.println(response.body());

                        if (response.body() != null && response.body() != null && response.body().size() > 0) {
                            for (Product product : response.body()) {
                                for (FoodListItem foodListItem : foodListItems) {
                                    if (product.getProductType() == foodListItem.getTitle()) {
                                        foodListItem.addProduct(product);
                                    }
                                }
                            }

                            List<FoodListItem> items = new ArrayList<>();
                            items.addAll(foodListItems);
                            ShopDetailActivity.this.foodListAdapter.notifyDataSetChanged();
                        }

                        ShopDetailActivity.this.inRequest = false;
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {
                        Log.d(TAG, ShopDetailActivity.TAG + "onFailure: ");
                        ShopDetailActivity.this.inRequest = false;
                    }
                });
            }

            this.tv_shop_detail_shop_name.setText(this.currentShop.getName());
            this.tv_shop_detail_shop_addresse.setText(this.currentShop.getFullAddress());
            String url = AppUtil.NOIMG;

            if (this.currentShop.getPhotos() != null && this.currentShop.getPhotos().size() > 0) {
                url = this.currentShop.getPhotos().get(0).getUrl();
            }

            Picasso.get().load(url).placeholder(R.drawable.noimage).into(this.iv_shop_detail_shop_photo);

            Location locShop = GPSTracker.getNewLocation("Shop", this.currentShop.getLatitude(), this.currentShop.getLongitude());
            String distance = GPSTracker.getDistance(locShop, new Location("current"));

            if (!distance.isEmpty()) {
                this.tv_shop_detail_shop_distance.setText(distance);
            } else {
                this.tv_shop_detail_shop_distance.setVisibility(View.GONE);
            }

            this.iv_shop_detail_shop_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ShopDetailActivity.this, CartActivity.class);
                    ShopDetailActivity.this.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_shop_detail;
    }

    public void getDataInIntent() {
        Log.d(TAG, "getDataInIntent: ");
        Intent intent = this.getIntent();

        if (intent != null && intent.getExtras() != null) {
            Serializable item = intent.getExtras().getSerializable(ShopDetailActivity.EXTRA_SHOP);
            this.distance = intent.getExtras().getInt(ShopDetailActivity.EXTRA_SHOP_DISTANCE);

            if (item instanceof Shop) {
                this.currentShop = (Shop)item;
            }
        }
    }
}
