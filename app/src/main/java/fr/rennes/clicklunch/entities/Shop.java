/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
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
    @Expose
    @SerializedName(ShopContract.COLUMN_NAME)
    private String name;

    @Expose
    @SerializedName(ShopContract.COLUMN_PHONENUMBER)
    private String phoneNumber;

    @Expose
    @SerializedName(ShopContract.COLUMN_EMAIL)
    private String email;

    @Expose
    @SerializedName(ShopContract.COLUMN_LONGITUDE)
    private double longitude;

    @Expose
    @SerializedName(ShopContract.COLUMN_LATITUDE)
    private double latitude;

    @Expose
    @SerializedName(ShopContract.COLUMN_ADDRESS)
    private String address;

    @Expose
    @SerializedName(ShopContract.COLUMN_POSTALCODE)
    private String postalCode;

    @Expose
    @SerializedName(ShopContract.COLUMN_CITY)
    private String city;

    @Expose
    @SerializedName(ShopContract.COLUMN_PHOTO)
    private List<Photo> photos;

    @Expose
    @SerializedName(ShopContract.COLUMN_CONFIGURATIONS)
    private List<Configuration> configurations;

    @Expose
    @SerializedName(ShopContract.COLUMN_CATEGORIES)
    private List<CategoryShop> categories;

    /**
     * Get the full address
     * @return addresse with city and postalcode.
     */
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

    /**
     * Get all categories in string.
     * @return string who content all catégories.
     */
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
