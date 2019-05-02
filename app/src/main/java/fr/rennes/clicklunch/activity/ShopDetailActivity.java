package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class ShopDetailActivity extends BaseActivity {

    public static final int MY_ACTIVITY_CODE = 2; // Activity code
    public static final String EXTRA_SHOP = "EXTRA_SHOP";
    public static final String EXTRA_SHOP_DISTANCE = "EXTRA_SHOP_DISTANCE";

    private Shop currentShop;
    private int distance = 0;

    private ImageView iv_shop_detail_shop_photo;
    private TextView tv_shop_detail_shop_addresse;
    private TextView tv_shop_detail_shop_name;
    private TextView tv_shop_detail_shop_distance;
    private RecyclerView rv_shop_detail_food_list;

    public ArrayList<FoodListItem> foodListItems = new ArrayList<>();
    private FoodListAdapter foodListAdapter;

    private void initTmpList() {
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.MENU));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.STARTER));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DISH));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DESSERT));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.DRINK));
        this.foodListItems.add(fillList(new FoodListItem(), ProductType.OTHER));
    }

    private FoodListItem fillList(FoodListItem products, ProductType type) {
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

    private void initComponent() {
        this.rv_shop_detail_food_list = this.findViewById(R.id.rv_shop_detail_food_list);
        this.tv_shop_detail_shop_addresse = this.findViewById(R.id.tv_shop_detail_shop_addresse);
        this.iv_shop_detail_shop_photo = this.findViewById(R.id.iv_shop_detail_shop_photo);
        this.tv_shop_detail_shop_name = this.findViewById(R.id.tv_shop_detail_shop_name);
        this.tv_shop_detail_shop_distance = this.findViewById(R.id.tv_shop_detail_shop_distance);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initComponent();
        this.initTmpList();
        this.initMenu();

        this.foodListAdapter = new FoodListAdapter(this.foodListItems);
        getDataInIntent();

        if (currentShop != null) {
            this.tv_shop_detail_shop_name.setText(this.currentShop.getName());
            this.tv_shop_detail_shop_addresse.setText(this.currentShop.getFullAddress());

            String url = AppUtil.NOIMG;

            if (this.currentShop.getPhoto() != null) {
                url = this.currentShop.getPhoto().getPath();
            }

            Picasso.get().load(url).placeholder(R.drawable.noimage).into(this.iv_shop_detail_shop_photo);

            Location locShop = new Location("Shop");
            locShop.setLatitude(this.currentShop.getLatitude());
            locShop.setLongitude(this.currentShop.getLongitude());

            String distance = GPSTracker.getDistance(locShop);

            if (!distance.isEmpty()) {
                this.tv_shop_detail_shop_distance.setText(distance);
            } else {
                this.tv_shop_detail_shop_distance.setVisibility(View.GONE);
            }

            this.foodListAdapter = new FoodListAdapter(this.foodListItems);
            this.rv_shop_detail_food_list.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            this.rv_shop_detail_food_list.setLayoutManager(layoutManager);
            this.rv_shop_detail_food_list.setAdapter(this.foodListAdapter);

            this.foodListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shop_detail;
    }

    public void getDataInIntent() {
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
