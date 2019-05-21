/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Command.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Command extends EntityBase {
    private int number;
    private List<CommandLine> commandLines;
}
