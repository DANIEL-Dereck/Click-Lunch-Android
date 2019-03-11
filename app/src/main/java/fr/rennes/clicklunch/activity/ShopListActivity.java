package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.ListShopItemAdapter;
import fr.rennes.clicklunch.entities.CategoryShop;
import fr.rennes.clicklunch.entities.Shop;

public class ShopListActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 1; // Activity code

    public ArrayList<Shop> tmpShopList = new ArrayList<>();
    private ListShopItemAdapter listShopItemAdapter;

    private RecyclerView lv_shop_list_shops;

    private void initTmpList()
    {
        for (int i = 0; i < 20; i++) {
            Shop item = new Shop();
            item.setName("shop test" + i);
            item.setCategories(new ArrayList<CategoryShop>());
            item.getCategories().add(new CategoryShop("TestCat" + i));
            item.getCategories().add(new CategoryShop("OtherCat" + i));
            tmpShopList.add(item);
        }
        
    }

    private void initComponent()
    {
        this.lv_shop_list_shops = findViewById(R.id.lv_shop_list_shops);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_shop_list);

        this.initTmpList();
        this.initComponent();

        this.listShopItemAdapter = new ListShopItemAdapter(tmpShopList);
        this.listShopItemAdapter.notifyDataSetChanged();
    }
}
