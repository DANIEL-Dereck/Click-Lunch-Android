package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class CommandLine extends EntityBase {
    private int quantity;
}
