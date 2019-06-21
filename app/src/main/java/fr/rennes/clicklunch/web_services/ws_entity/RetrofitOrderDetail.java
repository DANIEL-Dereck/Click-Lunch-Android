package fr.rennes.clicklunch.web_services.ws_entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors
@Data
public class RetrofitOrderDetail {
    @SerializedName("id")
    private int id;

    @SerializedName("quantity")
    private int quantity;
}
