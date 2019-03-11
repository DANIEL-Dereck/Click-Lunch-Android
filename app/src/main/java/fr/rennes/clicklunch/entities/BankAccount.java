/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class BankAccount.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class BankAccount extends EntityBase {
    private String iban;
    private String bic;
    private String bankName;
    private String titularName;

    private Shop shop;
}
