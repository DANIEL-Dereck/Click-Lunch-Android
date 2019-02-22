/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Product.
 */
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Menu {
    private String name;
    private double price;
    private String description;
    private Category category;
}
