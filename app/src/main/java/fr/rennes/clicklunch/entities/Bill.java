package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends EntityBase {
    private int number;
    private Command command;
    private Shop shop;
    private Client client;
}
