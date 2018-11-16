package fr.rennes.database.Entity;

import java.util.ArrayList;

import fr.rennes.database.Contrat.SQLContrat;

public class Table extends Composite {
    public Table ()
    {
        composites = new ArrayList<Composite>();
        this.builder = this;
    }

    public Table (Composite builder)
    {
        composites = new ArrayList<Composite>();
        this.builder = builder;
    }

    public Where table(String item) {
        this.builder.request += SQLContrat.FROM + item;

        Where next = new Where(this.builder);
        composites.add(next);
        return next;
    }

    public Where table(ArrayList<String> items)
    {
        this.builder.request += SQLContrat.FROM;
        for (String item : items) {
            request += item + ",";
        }

        Where next = new Where(this.builder);
        composites.add(next);
        return next;
    }
}