/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

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
public abstract class User extends EntityBase{
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String email;
    protected String phoneNumber;
    protected String address;
    protected String city;

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
}
