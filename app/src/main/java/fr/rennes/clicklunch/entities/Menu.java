/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Menu.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public abstract class Menu extends EntityBase {
    private List<Product> products;

    public Menu addProduct(Product product)
    {
        this.products.add(product);
        return this;
    }
}
