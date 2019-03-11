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
 * Class Address.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Address extends EntityBase {
    private String streetNumber;
    private String addOn;
    private String streetName;

    private City city;
    private User user;
}
