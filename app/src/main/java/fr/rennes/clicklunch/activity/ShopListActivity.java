package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.ListShopItemAdapter;
import fr.rennes.clicklunch.entities.CategoryShop;
import fr.rennes.clicklunch.entities.Photo;
import fr.rennes.clicklunch.entities.Shop;

public class ShopListActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 1; // Activity code

    private RecyclerView lv_shop_list_shops;
    private EditText et_shop_list_search_bar;

    public ArrayList<Shop> tmpShopList = new ArrayList<>();
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

        this.listShopItemAdapter = new ListShopItemAdapter(tmpShopList);
        this.lv_shop_list_shops.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.lv_shop_list_shops.setLayoutManager(layoutManager);

        this.lv_shop_list_shops.setAdapter(this.listShopItemAdapter);

        this.listShopItemAdapter.notifyDataSetChanged();
    }
}
