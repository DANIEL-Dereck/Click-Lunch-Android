package fr.rennes.clicklunch.utils;

import java.util.ArrayList;

import fr.rennes.clicklunch.App;
import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Product;
import fr.rennes.clicklunch.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodListItem {
    private ProductType title;
    private ArrayList<Product> products;

    public FoodListItem addProduct(Product product) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }

        this.products.add(product);
        return this;
    }

    public String getTitleString() {
        String result = "";

        switch (this.title) {
            case MENU:
                result = App.getAppContext().getString(R.string.ptype_menu);
                break;
            case STARTER:
                result = App.getAppContext().getString(R.string.ptype_starter);
                break;
            case DISH:
                result = App.getAppContext().getString(R.string.ptype_dish);
                break;
            case DESSERT:
                result = App.getAppContext().getString(R.string.ptype_dessert);
                break;
            case DRINK:
                result = App.getAppContext().getString(R.string.ptype_drink);
                break;
            default:
                result = App.getAppContext().getString(R.string.ptype_other);
                break;
        }

        return result;
    }
}
