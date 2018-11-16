package fr.rennes.database.Entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fr.rennes.database.Contrat.SQLContrat;
import fr.rennes.database.Manager.DatabaseManager;

public class RequestBuilder extends Composite {

    public static RequestBuilder instance;

    private RequestBuilder()
    {
        composites = new ArrayList<Composite>();
        this.builder = this;
        this.instance = this;
    }

    public static synchronized RequestBuilder getInstance()
    {
        if (instance == null) {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                    " is not initialized, call initInstance(..) method first.");
        }
        return instance;
    }

    public static synchronized void initInstance(){
        if (instance == null)
        {
            instance = new RequestBuilder();
        }
    }

    /* SELECT */
    public Table select(String item) {
        this.builder.request = SQLContrat.SELECT + item;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    public Table select(ArrayList<String> items) {
        this.builder.request = SQLContrat.SELECT;
        for (String item : items) {
            this.builder.request += item + ",";
        }

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    /* INSET / UPDATE */
    public Table insert(String item)
    {
        this.builder.request = SQLContrat.INSERT + SQLContrat.INTO;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    public Table insert(ArrayList<String> items)
    {
        this.builder.request = SQLContrat.INSERT + SQLContrat.INTO;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    public Table update(String item)
    {
        this.builder.request = SQLContrat.INSERT + SQLContrat.INTO;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    public Table update(ArrayList<String> items)
    {
        this.builder.request = SQLContrat.INSERT + SQLContrat.INTO;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    /* DELETE */
    public Table delete(String item)
    {
        this.builder.request = SQLContrat.DELETE + item;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    public Table delete(ArrayList<String> items)
    {
        this.builder.request = SQLContrat.DELETE;

        Table next = new Table(this.builder);
        composites.add(next);
        return next;
    }

    /* CREATE */
    public Field create(String table)
    {
        this.builder.request = SQLContrat.CREATE_TABLE + table;

        this.builder.isFirst = true;
        Field next = new Field(this.builder);
        composites.add(next);
        return next;
    }

    /* DROP */
    public String drop(String table)
    {
        this.builder.request = SQLContrat.DROP_TABLE + table;
        return this.builder.request;
    }

    public String dropIfExist(String table)
    {
        this.builder.request = SQLContrat.DROP_TABLE + SQLContrat.IF_EXIST + table;
        return this.builder.request;
    }


}

