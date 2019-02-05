package fr.rennes.clicklunch.entities;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public abstract class EntityBase {
    protected int id;
    protected boolean isDeleted;
    protected DateTime createdAt;
    protected DateTime updatedAt;
}
