package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@NoArgsConstructor
@AllArgsConstructor

/**
 * Class Address.
 */
public class Address extends EntityBase {
    private String streetNumber;
    private String addOn;
    private String streetName;
    private City city;

    private User user;
}
