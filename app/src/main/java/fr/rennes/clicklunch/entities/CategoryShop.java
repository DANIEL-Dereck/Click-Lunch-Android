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
 * Class CategoryShop.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class CategoryShop extends EntityBase {
    private String name;
}
