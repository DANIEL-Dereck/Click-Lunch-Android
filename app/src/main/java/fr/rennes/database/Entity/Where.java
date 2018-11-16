package fr.rennes.database.Entity;

import java.util.ArrayList;

import fr.rennes.database.Contrat.SQLContrat;

public class Where extends Composite {
    public Where()
    {
        composites = new ArrayList<Composite>();
        this.builder = this;
    }

    public Where (Composite builder)
    {
        composites = new ArrayList<Composite>();
        this.builder = builder;
    }


    public Operator where(String item)
    {
        this.builder.request += SQLContrat.WHERE + item;

        Operator next = new Operator(this.builder);
        composites.add(next);
        return next;
    }

    public Operator where(ArrayList<String> items)
    {
        this.builder.request = SQLContrat.WHERE;
        for (String item : items) {
            request += item + ",";
        }

        Operator next = new Operator(this.builder);
        composites.add(next);
        return next;
    }
}


