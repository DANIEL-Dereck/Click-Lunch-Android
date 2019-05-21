package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.ListShopItemAdapter;
import fr.rennes.clicklunch.entities.CategoryShop;
import fr.rennes.clicklunch.entities.Photo;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class ShopListActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x20;
    public static final String TAG = "ShopListActivity";

    private RecyclerView lv_shop_list_shops;
    private EditText et_shop_list_search_bar;

    public ArrayList<Shop> tmpShopList = new ArrayList<>();
    public ArrayList<Shop> shopList = new ArrayList<>();
    private ListShopItemAdapter listShopItemAdapter;

    private void initTmpList()
    {
        Log.d(TAG, "initTmpList: ");
        Shop forum = new Shop();
        forum.setName("Le Forum");
        forum.setLatitude( 48.0460793);
        forum.setLongitude( -1.7412650);
        forum.setPhoto(new Photo("https://leforumrestaurant.files.wordpress.com/2016/04/cropped-wp_20160216_006.jpg?w=1200"));
        forum.setAddress("7 rue de lalala");
        forum.setCity("Bruz");
        forum.setCategories(new ArrayList<CategoryShop>());
        forum.getCategories().add(new CategoryShop("Sanwdich"));
        forum.getCategories().add(new CategoryShop("Pizza"));
        tmpShopList.add(forum);

        for (int i = 0; i < 20; i++) {
            Shop item = new Shop();
            item.setName("shop test" + i);
            item.setLongitude(i);
            item.setLatitude(i);
            item.setAddress(i + " rue de lalal");
            item.setCity("Rennes");
            item.setCategories(new ArrayList<CategoryShop>());
            item.getCategories().add(new CategoryShop("Pizza" + i));
            item.getCategories().add(new CategoryShop("Burger" + i));
            tmpShopList.add(item);
        }
    }

    @Override
    protected void initComponent()
    {
        Log.d(TAG, "initComponent: ");
        this.lv_shop_list_shops = findViewById(R.id.lv_shop_list_shops);
        this.et_shop_list_search_bar = findViewById(R.id.et_shop_list_search_bar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        this.initTmpList();

        CartLocalStorage.getInstance().clear();
        shopList.addAll(tmpShopList);
        this.listShopItemAdapter = new ListShopItemAdapter(shopList);

        this.et_shop_list_search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "et_shop_list_search_bar.beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "et_shop_list_search_bar.onTextChanged: ");
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
                Log.d(TAG, "et_shop_list_search_bar.afterTextChanged: ");
            }
        });

        this.listShopItemAdapter.setShops(shopList);
        this.listShopItemAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "listShopItemAdapter.onClick: ");
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

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_shop_list;
    }
}
