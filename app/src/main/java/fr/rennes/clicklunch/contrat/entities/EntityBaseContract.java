/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.contrat.entities;

import fr.rennes.clicklunch.contrat.BaseContract;

/**
 * Contract class for EntityBase.
 */
public abstract class EntityBaseContract extends BaseContract {
    /**
     * Column id.
     */
    public static final String COLUMN_ID = "id";

    /**
     * Column isDeleted.
     */
    public static final String COLUMN_ISDELETED = "is_deleted";

    /**
     * Column createdAt.
     */
    public static final String COLUMN_CREATEDAT = "created_at";

    /**
     * Column updatedAt.
     */
    public static final String COLUMN_UPDATEDAT = "updated_at";
}
