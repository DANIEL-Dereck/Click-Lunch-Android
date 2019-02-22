/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Command.
 */
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Command extends EntityBase {
    private int number;
}
