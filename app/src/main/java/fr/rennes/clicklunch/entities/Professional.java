/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Professional.
 */
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Professional extends User{
    private Shop shop;
}
