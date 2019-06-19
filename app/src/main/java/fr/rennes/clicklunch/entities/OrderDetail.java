/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import fr.rennes.clicklunch.contrat.entities.OrderDetailContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class OrderDetail.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class OrderDetail extends EntityBase {
    @SerializedName(OrderDetailContract.COLUMN_QUANTITY)
    private int quantity;

    @SerializedName(OrderDetailContract.COLUMN_PRODUCT)
    private Product product;

    @SerializedName(OrderDetailContract.COLUMN_ORDER)
    private Order order;
}
