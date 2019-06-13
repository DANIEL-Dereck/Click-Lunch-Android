/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.contrat.entities.MenuContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Menu.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public abstract class Menu extends EntityBase {
    @SerializedName(MenuContract.COLUMN_PRODUCTS)
    private List<Product> products;

    public Menu addProduct(Product product)
    {
        this.products.add(product);
        return this;
    }
}
