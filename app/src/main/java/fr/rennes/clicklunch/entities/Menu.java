package fr.rennes.clicklunch.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Menu extends EntityBase {
    private List<Product> products;

    public Menu addProduct(Product product)
    {
        this.products.add(product);
        return this;
    }
}
