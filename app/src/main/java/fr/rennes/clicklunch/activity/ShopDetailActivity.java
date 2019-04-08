package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.enums.ProductType;
import fr.rennes.clicklunch.utils.FoodListItem;

public class ShopDetailActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 2; // Activity code

    private LinearLayout ll_shop_detail_food_list;

    public ArrayList<FoodListItem> foodListItems = new ArrayList<>();

    private void initTmpList() {
        foodListItems.add(fillList(new FoodListItem(), ProductType.MENU));
        foodListItems.add(fillList(new FoodListItem(), ProductType.STARTER));
        foodListItems.add(fillList(new FoodListItem(), ProductType.DISH));
        foodListItems.add(fillList(new FoodListItem(), ProductType.DESSERT));
        foodListItems.add(fillList(new FoodListItem(), ProductType.DRINK));
        foodListItems.add(fillList(new FoodListItem(), ProductType.OTHER));
    }

    private FoodListItem fillList(FoodListItem products, ProductType type) {
        products.setTitle(type);

        for (int i = 0; i < 20; i++) {
            Product product = new Product();
            product.setName("productName");
            product.setPrice(20.5);
            product.setDescription("Product description test");
            product.setProductType(type);

            if (type == ProductType.MENU) {
                ArrayList<Product> productsMenu = new ArrayList<>();

                productsMenu.add(new Product("Menu Starter Product", 25.5, "description menu", null, ProductType.STARTER, null));
                productsMenu.add(new Product("Menu dish Product", 25.5, "description menu", null, ProductType.DISH, null));
                productsMenu.add(new Product("Menu dessert Product", 25.5, "description menu", null, ProductType.DESSERT, null));
                productsMenu.add(new Product("Menu drink Product", 25.5, "description menu", null, ProductType.DRINK, null));
                productsMenu.add(new Product("Menu other Product", 25.5, "description menu", null, ProductType.OTHER, null));

                product.setProducts(productsMenu);
            }

            products.addProduct(product);
        }

        return products;
    }

    private void initComponent() {
        this.ll_shop_detail_food_list = findViewById(R.id.ll_shop_detail_food_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        this.initComponent();
        this.initTmpList();
    }
}
