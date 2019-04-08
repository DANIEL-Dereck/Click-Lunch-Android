/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import fr.rennes.clicklunch.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Product.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Product extends Menu {
    private String name;
    private double price;
    private String description;
    private Category category;
    private ProductType productType;
    private Photo photo;
}
