/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.adapter.DetailFoodAdapter;
import fr.rennes.clicklunch.decorator.VerticalSpaceItemDecoration;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class ProductDetailActivity extends BaseActivity {
    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x40;
    public static final String TAG = "ProductDetailActivity";

    public static final String EXTRA_PRODUCT = "EXTRA_PRODUCT";

    private TextView tv_detail_food_food_name;
    private TextView tv_detail_food_food_price;
    private Button btn_detail_food_back;
    private Button btn_detail_food_validate;
    private RecyclerView rv_detail_food_lst_product;

    private Product selectedProduct;
    private List<Product> products;
    private DetailFoodAdapter detailFoodAdapter;

    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
        this.tv_detail_food_food_name = this.findViewById(R.id.tv_detail_food_food_name);
        this.tv_detail_food_food_price = this.findViewById(R.id.tv_detail_food_food_price);
        this.btn_detail_food_back = this.findViewById(R.id.btn_detail_food_back);
        this.btn_detail_food_validate = this.findViewById(R.id.btn_detail_food_validate);
        this.rv_detail_food_lst_product = this.findViewById(R.id.rv_detail_food_lst_product);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            this.selectedProduct = (Product) intent.getExtras().getSerializable(this.EXTRA_PRODUCT);
        }

        this.products = new ArrayList<>();

        if (selectedProduct != null) {
            tv_detail_food_food_name.setText(selectedProduct.getName());
            tv_detail_food_food_price.setText(selectedProduct.getPriceString() + " €");

            if (selectedProduct.getProducts() != null && selectedProduct.getProducts().size() > 0) {
                this.products.addAll(selectedProduct.getProducts());
            } else {
                this.products.add(selectedProduct);
            }

            this.detailFoodAdapter = new DetailFoodAdapter(products, this);

            this.rv_detail_food_lst_product.setLayoutManager(new GridLayoutManager(this, 1));
            this.rv_detail_food_lst_product.addItemDecoration(new VerticalSpaceItemDecoration(this, R.dimen.dimenMarginDefault));
            this.rv_detail_food_lst_product.setAdapter(detailFoodAdapter);
            this.rv_detail_food_lst_product.setHasFixedSize(true);


            btn_detail_food_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            });

            btn_detail_food_validate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartLocalStorage.getInstance().addProduct(selectedProduct);
                    setResult(RESULT_OK);
                    finish();
                }
            });

            this.detailFoodAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_product_detail;
    }
}
