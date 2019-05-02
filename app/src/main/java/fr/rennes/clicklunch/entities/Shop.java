/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Class Shop.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Shop extends EntityBase {
    private String name;
    private String siret;
    private String siren;
    private String phoneNumber;
    private String email;
    private double longitude;
    private double latitude;
    private String address;
    private String city;
    private Photo photo;

    private Professional professional;
    private BankAccount bankAccount;
    private List<Configuration> configurations;
    private List<CategoryShop> categories;

    public String getFullAddress() {
        String result = "";

        if (this.address != null) {
            result += this.address;
        }

        if (this.city != null) {
            result += "," + this.city;
        }

        return result;
    }

    public String getCategoriesString()
    {
        String result = "";

        for (CategoryShop categoryShop : categories) {
            result += categoryShop.getName() +
                    ((categories.size() > 1 && categories.indexOf(categoryShop) != (categories.size() - 1)) ? ", " : "");
        }

        return result;
    }
}
