package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Shop extends EntityBase {
    private String name;
    private String siret;
    private String siren;
    private String phoneNumber;
    private String email;
    private double longitude;
    private double latitude;
}
