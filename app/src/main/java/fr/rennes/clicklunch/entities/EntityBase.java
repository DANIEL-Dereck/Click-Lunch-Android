/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import fr.rennes.clicklunch.contrat.entities.EntityBaseContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class EntityBase.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public abstract class EntityBase implements Serializable {
    @SerializedName(EntityBaseContract.COLUMN_ID)
    protected int id;

    @SerializedName(EntityBaseContract.COLUMN_ISDELETED)
    protected boolean isDeleted;

    @SerializedName(EntityBaseContract.COLUMN_CREATEDAT)
    protected Date createdAt;

    @SerializedName(EntityBaseContract.COLUMN_UPDATEDAT)
    protected Date updatedAt;
}
