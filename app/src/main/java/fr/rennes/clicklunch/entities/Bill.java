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
 * Class Bill.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Bill extends EntityBase {
    private int number;
    private Command command;
    private Shop shop;
    private Client client;
}
