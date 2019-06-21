/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.CartItemAdapter;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.utils.CartLocalStorage;

/**
 * Cart Activity.
 */
public class CartActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x50;
    public static final String TAG = "CartActivity";

    private RecyclerView rv_cart_items;
    private TextView tv_total;

    private Button btn_activity_cart_back;
    private Button btn_activity_cart_validate;

    private CartItemAdapter cartItemAdapter;
    private List<Product> products;

    /**
     * Init component in activity
     */
    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
        this.rv_cart_items = this.findViewById(R.id.rv_cart_items);
        this.tv_total = this.findViewById(R.id.tv_total);
        this.btn_activity_cart_validate = this.findViewById(R.id.btn_activity_cart_validate);
        this.btn_activity_cart_back = this.findViewById(R.id.btn_activity_cart_back);
    }

    /**
     * On create methode.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        this.products = CartLocalStorage.getInstance().getAll();
        this.cartItemAdapter = new CartItemAdapter(this.products, this);

        this.rv_cart_items.setLayoutManager(new LinearLayoutManager(this));
        this.rv_cart_items.setAdapter(this.cartItemAdapter);

        this.updateTotal();
        this.cartItemAdapter.notifyDataSetChanged();

        this.btn_activity_cart_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.btn_activity_cart_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CartLocalStorage.getInstance().countItems() > 0) {
                    Intent intent = new Intent(CartActivity.this, ChooseHourActivity.class);
                    CartActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(
                            CartActivity.this,
                            CartActivity.this.getText(R.string.cart_empty),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (AppUtil.IS_EXIT_FLAG_RAISED) {
            finish();
        }
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

    public void updateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        this.tv_total.setText(f.format(total) + " €");
    }

}
