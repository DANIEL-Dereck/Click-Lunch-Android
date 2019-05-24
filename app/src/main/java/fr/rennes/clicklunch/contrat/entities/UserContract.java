/***************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 **************************/

package fr.rennes.clicklunch.contrat.entities;

/**
 * Contract class for User.
 */
public abstract class UserContract extends EntityBaseContract {
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_POSTALCODE = "postalCode";
    public static final String COLUMN_CITY = "city";
}
