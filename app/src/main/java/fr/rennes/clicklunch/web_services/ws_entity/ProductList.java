package fr.rennes.clicklunch.web_services.ws_entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.rennes.clicklunch.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
    @SerializedName("data")
    private List<Product> products;
}
