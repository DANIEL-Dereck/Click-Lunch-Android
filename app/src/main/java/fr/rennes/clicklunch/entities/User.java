/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class User.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public abstract class User extends EntityBase{
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String email;
    protected String phoneNumber;

    protected Address address;
}
