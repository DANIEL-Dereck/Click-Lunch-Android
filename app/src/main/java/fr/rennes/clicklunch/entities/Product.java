/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import java.text.DecimalFormat;

import fr.rennes.clicklunch.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Product.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Product extends Menu {
    private String name;
    private double price;
    private String description;
    private Category category;
    private ProductType productType;
    private Photo photo;

    public String getPriceString() {
        String result = "";

        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);

        result = f.format(this.price);

        return result;
    }
}
