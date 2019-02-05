package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class CommandLine extends EntityBase {
    private int quantity;
}
