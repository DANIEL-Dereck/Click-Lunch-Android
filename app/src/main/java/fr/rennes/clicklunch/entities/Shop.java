/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.contrat.entities.ShopContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Shop.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Shop extends EntityBase {
    @SerializedName(ShopContract.COLUMN_NAME)
    private String name;

    @SerializedName(ShopContract.COLUMN_PHONENUMBER)
    private String phoneNumber;

    @SerializedName(ShopContract.COLUMN_EMAIL)
    private String email;

    @SerializedName(ShopContract.COLUMN_LONGITUDE)
    private double longitude;

    @SerializedName(ShopContract.COLUMN_LATITUDE)
    private double latitude;

    @SerializedName(ShopContract.COLUMN_ADDRESS)
    private String address;

    @SerializedName(ShopContract.COLUMN_POSTALCODE)
    private String postalCode;

    @SerializedName(ShopContract.COLUMN_CITY)
    private String city;

    @SerializedName(ShopContract.COLUMN_PHOTO)
    private Photo photo;

    @SerializedName(ShopContract.COLUMN_CONFIGURATIONS)
    private List<Configuration> configurations;

    @SerializedName(ShopContract.COLUMN_CATEGORIES)
    private List<CategoryShop> categories;

    public String getFullAddress() {
        String result = "";

        if (this.address != null) {
            result += this.address;
        }

        if (this.city != null) {
            result += "\n" + this.city;

            if (this.postalCode != null) {
                result += ", " + this.postalCode;
            }
        }

        return result;
    }

    public String getCategoriesString()
    {
        String result = "";

        if (this.categories != null) {
            for (CategoryShop categoryShop : this.categories) {
                result += categoryShop.getName() +
                        ((categories.size() > 1 && categories.indexOf(categoryShop) != (categories.size() - 1)) ? ", " : "");
            }
        }

        return result;
    }
}
