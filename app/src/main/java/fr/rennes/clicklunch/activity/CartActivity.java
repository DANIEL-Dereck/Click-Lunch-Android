package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.util.Log;

import fr.rennes.clicklunch.App;
import fr.rennes.clicklunch.R;

/**
 * Cart Activity.
 */
public class CartActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x50;
    public static final String TAG = "CartActivity";

    /**
     * Init component in activity
     */
    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
    }

    /**
     * On create methode.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    /**
     * Get content view.
     * @return id of view.
     */
    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_cart;
    }

}
