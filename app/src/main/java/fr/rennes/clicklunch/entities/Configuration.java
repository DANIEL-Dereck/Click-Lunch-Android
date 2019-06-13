/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import fr.rennes.clicklunch.contrat.entities.ConfigurationContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class Configuration.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@EqualsAndHashCode(callSuper=true)
public class Configuration extends EntityBase {
    @SerializedName(ConfigurationContract.COLUMN_KEY)
    private String key;

    @SerializedName(ConfigurationContract.COLUMN_VALUE)
    private String value;

    @SerializedName(ConfigurationContract.COLUMN_SHOP)
    private Shop shop;

    public Configuration setConfiguration(String key, String value)
    {
        this.key = key;
        this.value = value;
        return this;
    }

    public Configuration setConfiguration(String key, int value)
    {
        return this.setConfiguration(key, Integer.toString(value));
    }

    public Configuration setConfiguration(String key, double value)
    {
        return this.setConfiguration(key, Double.toString(value));
    }

    public Configuration setConfiguration(String key, boolean value)
    {
        return this.setConfiguration(key, Boolean.toString(value));
    }
}
