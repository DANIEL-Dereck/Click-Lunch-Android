package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class City extends EntityBase {
    private String name;
    private String postalCode;
}
