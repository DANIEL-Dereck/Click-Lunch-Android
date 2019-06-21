/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services.ws_entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors
@Data
public class RetrofitOrder {
    @SerializedName("recoveryTime")
    private String recoveryTime;

    @SerializedName("products")
    private List<RetrofitOrderDetail> products;

    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors
    @Data
    public class RetrofitOrderResult extends RetrofitOrder {
        @SerializedName("orderNumber")
        private String number;
    }
}
