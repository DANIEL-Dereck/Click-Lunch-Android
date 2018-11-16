package fr.rennes.database.Entity;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import fr.rennes.database.Manager.DatabaseManager;

/**
 * Composite class.
 */
public class Composite {
    /**
     * List of composite.
     */
    protected ArrayList<Composite> composites = null;

    /**
     * Request string.
     */
    protected String request = null;

    /**
     *
     */
    protected Composite builder = null;
    protected Boolean isFirst;

    public void reset()
    {
        this.request = "";
    }

    public String end()
    {
        String query = this.builder.request + " ;";
        reset();
        return query;
    }

    /**
     * Execute the query
     */
    public void build() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.execSQL(end());
        DatabaseManager.getInstance().closeDatabase();
    }
}
