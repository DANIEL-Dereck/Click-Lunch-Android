/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import fr.rennes.clicklunch.contrat.entities.OrderContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Order.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Order extends EntityBase {
    @Expose
    @SerializedName(OrderContract.COLUMN_NUMBER)
    private transient String number;

    @Expose
    @SerializedName(OrderContract.COLUMN_ORDERDETAIL)
    private List<OrderDetail> orderDetails;

    @Expose
    @SerializedName(OrderContract.COLUMN_RECOVERYTIME)
    private Date recoveryTime;
}
