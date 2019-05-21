package fr.rennes.clicklunch.utils;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.clicklunch.entities.Product;

public class CartLocalStorage {
    private static List<Product> products = new ArrayList<>();
    private static CartLocalStorage instance;

    private CartLocalStorage() {
        products = new ArrayList<>();
    }

    public static CartLocalStorage getInstance() {
        if (instance == null) {
            instance = new CartLocalStorage();
        }

        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        }
    }

    public List<Product> getAll() {
        return products;
    }

    public int countItems() {
        return products.size();
    }

    public void clear() {
        products.removeAll(getAll());
    }
}
