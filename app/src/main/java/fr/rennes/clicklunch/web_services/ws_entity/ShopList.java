/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services.ws_entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.entities.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopList {
    @SerializedName("result")
    private List<Shop> shops;
}
