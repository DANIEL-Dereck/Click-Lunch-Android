package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class BankAccount extends EntityBase {
    private String iban;
    private String bic;
    private String bankName;
    private String titularName;
}
