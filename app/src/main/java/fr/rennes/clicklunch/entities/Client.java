/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.contrat.entities.ClientContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Client.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Client extends User {
    @Expose
    @SerializedName(ClientContract.COLUMN_BILLS)
    private List<Bill> bills;

    @Expose
    @SerializedName(ClientContract.COLUMN_ROLE)
    private String role = "CUSTOMER";
}
