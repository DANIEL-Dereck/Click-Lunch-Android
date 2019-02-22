/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Shop.
 */
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends EntityBase {
    private String name;
    private String siret;
    private String siren;
    private String phoneNumber;
    private String email;
    private double longitude;
    private double latitude;

    private Professional professional;
    private BankAccount bankAccount;
    private List<Configuration> configurations;
    private List<CategoryShop> categories;
}
