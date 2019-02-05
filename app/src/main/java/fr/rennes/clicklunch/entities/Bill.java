package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Bill extends EntityBase {
    private int number;
}
