package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Shop;
import fr.rennes.clicklunch.utils.GPSTracker;

public class ShopDetailActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 2; // Activity code
    public static final String EXTRA_SHOP = "EXTRA_SHOP";
    public static final String EXTRA_SHOP_DISTANCE = "EXTRA_SHOP_DISTANCE";

    private Shop currentShop;
    private int distance = 0;

    private TextView tv_shop_detail_shop_name;
    private TextView tv_shop_detail_shop_distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        getDataInIntent();
        initComponent();

        if (currentShop != null) {
            this.tv_shop_detail_shop_name.setText(currentShop.getName());

            Location locShop = new Location("Shop");
            locShop.setLatitude(currentShop.getLatitude());
            locShop.setLongitude(currentShop.getLongitude());

            String distance = GPSTracker.getDistance(locShop);

            if (!distance.isEmpty()) {
                tv_shop_detail_shop_distance.setText(distance);
            } else {
                tv_shop_detail_shop_distance.setVisibility(View.GONE);
            }
        }
    }

    public void getDataInIntent() {
        Intent intent = this.getIntent();

        if (intent != null && intent.getExtras() != null) {
            Serializable item = intent.getExtras().getSerializable(ShopDetailActivity.EXTRA_SHOP);
            distance = intent.getExtras().getInt(ShopDetailActivity.EXTRA_SHOP_DISTANCE);

            if (item instanceof Shop) {
                this.currentShop = (Shop)item;
            }
        }
    }

    private void initComponent() {
        this.tv_shop_detail_shop_name = findViewById(R.id.tv_shop_detail_shop_name);
        this.tv_shop_detail_shop_distance = findViewById(R.id.tv_shop_detail_shop_distance);
    }
}
