/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import fr.rennes.clicklunch.contrat.entities.OrderDetailContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class OrderDetail.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class OrderDetail implements Serializable {
    @Expose
    @SerializedName(OrderDetailContract.COLUMN_ID)
    private int productId;

    @Expose
    @SerializedName(OrderDetailContract.COLUMN_QUANTITY)
    private int quantity;

    @Expose
    @SerializedName(OrderDetailContract.COLUMN_PRODUCT)
    private transient Product product;

    @Expose(serialize = false, deserialize = false)
    @SerializedName(OrderDetailContract.COLUMN_ORDER)
    private transient Order order;
}
