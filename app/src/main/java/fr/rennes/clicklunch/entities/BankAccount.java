package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends EntityBase {
    private String iban;
    private String bic;
    private String bankName;
    private String titularName;

    private Shop shop;
}
