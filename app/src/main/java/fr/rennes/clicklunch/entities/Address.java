package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor

/**
 * Class Address.
 */
public class Address extends EntityBase {
    private String streetNumber;
    private String addOn;
    private String streetName;
    private City city;
}
