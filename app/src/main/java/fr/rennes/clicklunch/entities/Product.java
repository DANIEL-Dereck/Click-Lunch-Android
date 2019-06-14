/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.util.List;

import fr.rennes.clicklunch.contrat.entities.ProductContract;
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
    @SerializedName(ProductContract.COLUMN_NAME)
    private String name;

    @SerializedName(ProductContract.COLUMN_PRICE)
    private double price;

    @SerializedName(ProductContract.COLUMN_DESCRIPTION)
    private String description;

    @SerializedName(ProductContract.COLUMN_CATEGORY)
    private Category category;

    @SerializedName(ProductContract.COLUMN_PRODUCTTYPE)
    private ProductType productType;

    @SerializedName(ProductContract.COLUMN_PHOTO)
    private List<Photo> photos;

    public String getPriceString() {
        String result = "";

        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);

        result = f.format(this.price);

        return result;
    }
}
