/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.web_services.ws_entity;

import com.google.gson.annotations.SerializedName;

import fr.rennes.clicklunch.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @SerializedName("client")
    private Client client;

    @SerializedName("message")
    private String message;

    @SerializedName("token")
    private String token;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;
}
