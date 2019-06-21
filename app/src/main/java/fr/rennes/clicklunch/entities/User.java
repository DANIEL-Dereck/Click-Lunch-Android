/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import fr.rennes.clicklunch.contrat.entities.UserContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class User.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public abstract class User extends EntityBase {
    @Expose
    @SerializedName(UserContract.COLUMN_FIRSTNAME)
    protected String firstname;

    @Expose
    @SerializedName(UserContract.COLUMN_LASTNAME)
    protected String lastname;

    @Expose
    @SerializedName(UserContract.COLUMN_PASSWORD)
    protected String password;

    @Expose
    @SerializedName(UserContract.COLUMN_EMAIL)
    protected String email;

    @Expose
    @SerializedName(UserContract.COLUMN_PHONENUMBER)
    protected String phoneNumber;

    @Expose
    @SerializedName(UserContract.COLUMN_ADDRESS)
    protected String address;

    @Expose
    @SerializedName(UserContract.COLUMN_POSTALCODE)
    protected String postalCode;

    @Expose
    @SerializedName(UserContract.COLUMN_CITY)
    protected String city;

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
            result += "," + this.city;

            if (this.postalCode != null) {
                result += ", " + this.postalCode;
            }
        }

        return result;
    }
}
