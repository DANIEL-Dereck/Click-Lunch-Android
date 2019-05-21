package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.rennes.clicklunch.App;
import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class ProductDetailActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x40;
    public static final String TAG = "ProductDetailActivity";

    public static final String EXTRA_PRODUCT = "EXTRA_PRODUCT";

    TextView tv_detail_food_food_name;
    TextView tv_detail_food_food_price;
    Button btn_detail_food_back;
    Button btn_detail_food_validate;

    Product selectedProduct;

    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
        tv_detail_food_food_name = this.findViewById(R.id.tv_detail_food_food_name);
        tv_detail_food_food_price = this.findViewById(R.id.tv_detail_food_food_price);
        btn_detail_food_back = this.findViewById(R.id.btn_detail_food_back);
        btn_detail_food_validate = this.findViewById(R.id.btn_detail_food_validate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            this.selectedProduct = (Product) intent.getExtras().getSerializable(this.EXTRA_PRODUCT);
        }

        if (selectedProduct != null) {
            tv_detail_food_food_name.setText(selectedProduct.getName());
            tv_detail_food_food_price.setText(selectedProduct.getPriceString() + " €");

            btn_detail_food_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            btn_detail_food_validate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartLocalStorage.getInstance().addProduct(selectedProduct);
                    finish();
                }
            });
        }
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_product_detail;
    }

}
