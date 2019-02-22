/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Bill.
 */
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends EntityBase {
    private int number;
    private Command command;
    private Shop shop;
    private Client client;
}
