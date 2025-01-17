/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import fr.rennes.clicklunch.contrat.entities.BillContract;
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
    @Expose
    @SerializedName(BillContract.COLUMN_NUMBER)
    private int number;

    @Expose
    @SerializedName(BillContract.COLUMN_COMMAND)
    private Order order;

    @Expose
    @SerializedName(BillContract.COLUMN_SHOP)
    private Shop shop;

    @Expose
    @SerializedName(BillContract.COLUMN_CLIENT)
    private Client client;
}
