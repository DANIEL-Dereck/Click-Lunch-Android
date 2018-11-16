package fr.rennes.database.Entity;

import java.util.ArrayList;

import fr.rennes.database.Contrat.SQLContrat;

public class Operator extends Composite {
    public Operator ()
    {
        composites = new ArrayList<Composite>();
        this.builder = this;
    }

    public Operator (Composite builder)
    {
        composites = new ArrayList<Composite>();
        this.builder = builder;
    }

    public Operator and(String item) {
        this.builder.request += SQLContrat.AND + item;

        Operator next = new Operator(this.builder);
        composites.add(next);
        return next;
    }

    public Operator or(String item) {
        this.builder.request += SQLContrat.OR + item;

        Operator next = new Operator(this.builder);
        composites.add(next);
        return next;
    }
}
