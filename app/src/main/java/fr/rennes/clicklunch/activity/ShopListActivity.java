package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.ListShopItemAdapter;
import fr.rennes.clicklunch.entities.CategoryShop;
import fr.rennes.clicklunch.entities.Photo;
import fr.rennes.clicklunch.entities.Shop;

public class ShopListActivity extends BaseActivity {

    public static final int MY_ACTIVITY_CODE = 1; // Activity code

    private RecyclerView lv_shop_list_shops;
    private EditText et_shop_list_search_bar;

    public ArrayList<Shop> tmpShopList = new ArrayList<>();
    public ArrayList<Shop> shopList = new ArrayList<>();
    private ListShopItemAdapter listShopItemAdapter;

    private void initTmpList()
    {
        Shop forum = new Shop();
        forum.setName("Le Forum");
        forum.setLatitude( 48.0460793);
        forum.setLongitude( -1.7412650);
        forum.setCategories(new ArrayList<CategoryShop>());
        forum.getCategories().add(new CategoryShop("Sanwdich"));
        forum.getCategories().add(new CategoryShop("Pizza"));
        forum.setPhotos(new ArrayList<Photo>());
        forum.getPhotos().add(new Photo("https://leforumrestaurant.files.wordpress.com/2016/04/cropped-wp_20160216_006.jpg?w=1200"));
        tmpShopList.add(forum);

        for (int i = 0; i < 20; i++) {
            Shop item = new Shop();
            item.setName("shop test" + i);
            item.setLongitude(i);
            item.setLatitude(i);
            item.setCategories(new ArrayList<CategoryShop>());
            item.getCategories().add(new CategoryShop("Pizza" + i));
            item.getCategories().add(new CategoryShop("Burger" + i));
            tmpShopList.add(item);
        }
    }

    private void initComponent()
    {
        this.lv_shop_list_shops = findViewById(R.id.lv_shop_list_shops);
        this.et_shop_list_search_bar = findViewById(R.id.et_shop_list_search_bar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_shop_list);

        this.initTmpList();
        this.initComponent();
        this.initMenu();

        //TODO: set shop her after call WS.
//        this.tmpShopList = new ArrayList<>(new ArrayList<Shop>());
//        this.tmpShopList = ;

        shopList.addAll(tmpShopList);
        this.listShopItemAdapter = new ListShopItemAdapter(shopList);

        this.et_shop_list_search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                shopList.removeAll(shopList);
                for (Shop shop : tmpShopList) {

                    if (shop.getName().toLowerCase().contains(s.toString().toLowerCase())
                            || shop.getCategoriesString().toLowerCase().contains(s.toString().toLowerCase())) {
                        shopList.add(shop);
                    }
                }
                ShopListActivity.this.listShopItemAdapter.setShops(shopList);
                ShopListActivity.this.listShopItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        this.listShopItemAdapter.setShops(shopList);
        this.listShopItemAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ShopListActivity.this, ShopDetailActivity.class);
                int position = lv_shop_list_shops.getChildLayoutPosition(v);
                Shop selectedShop = ShopListActivity.this.tmpShopList.get(position);
                myIntent.putExtra(ShopDetailActivity.EXTRA_SHOP, selectedShop);
                startActivity(myIntent);
            }
        });

        this.lv_shop_list_shops.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.lv_shop_list_shops.setLayoutManager(layoutManager);

        this.lv_shop_list_shops.setAdapter(this.listShopItemAdapter);

        this.listShopItemAdapter.notifyDataSetChanged();
    }
}
