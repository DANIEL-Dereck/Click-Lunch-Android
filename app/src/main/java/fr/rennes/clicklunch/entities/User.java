package fr.rennes.clicklunch.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors
@NoArgsConstructor
@AllArgsConstructor
public abstract class User extends EntityBase{
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String email;
    protected String phoneNumber;
}
