package fr.rennes.clicklunch.utils;

import java.util.ArrayList;

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
}
