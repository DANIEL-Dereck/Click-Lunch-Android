/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class EntityBase.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public abstract class EntityBase {
    protected int id;
    protected boolean isDeleted;
    protected DateTime createdAt;
    protected DateTime updatedAt;
}
