/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.contrat.entities.CommandContract;
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
    @SerializedName(CommandContract.COLUMN_NUMBER)
    private int number;

    @SerializedName(CommandContract.COLUMN_COMMANDLINES)
    private List<CommandLine> commandLines;
}
