package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.os.Bundle;

import fr.rennes.clicklunch.R;

public class ShopDetailActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 2; // Activity code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
    }
}
