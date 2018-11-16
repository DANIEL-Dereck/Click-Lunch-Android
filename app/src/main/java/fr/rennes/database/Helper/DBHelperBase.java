package fr.rennes.database.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.rennes.database.Contrat.DatabaseContrat;

public abstract class DBHelperBase extends SQLiteOpenHelper {

    /* LOG STRING VALUES */
    private final String LOGTAG = this.getClass().toString();
    private final String ONOPEN = "onOpen";

    private String databaseName;
    private int databaseVersion;
    private String pragma;

    public DBHelperBase(Context context, String databaseName, int databaseVersion, String pragma) {
        super(context, databaseName, null, databaseVersion);
        this.databaseName = databaseName;
        this.databaseVersion = databaseVersion;
        this.pragma = pragma;
    }

    public DBHelperBase(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
        this.databaseName = databaseName;
        this.databaseVersion = databaseVersion;
        this.pragma = DatabaseContrat.DEFAULT_PRAGMA;
    }

    public DBHelperBase(Context context, String databaseName) {
        super(context, databaseName, null, DatabaseContrat.DEFAULT_DATABASE_VERSION);
        this.databaseName = databaseName;
        this.databaseVersion = DatabaseContrat.DEFAULT_DATABASE_VERSION;
        this.pragma = DatabaseContrat.DEFAULT_PRAGMA;
    }

    public DBHelperBase(Context context) {
        super(context, DatabaseContrat.DEFAULT_DATABASE_NAME, null, DatabaseContrat.DEFAULT_DATABASE_VERSION);
        this.databaseName = DatabaseContrat.DEFAULT_DATABASE_NAME;
        this.databaseVersion = DatabaseContrat.DEFAULT_DATABASE_VERSION;
        this.pragma = DatabaseContrat.DEFAULT_PRAGMA;
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        Log.d(this.LOGTAG, this.ONOPEN);
        super.onOpen(db);
        if (!db.isReadOnly()){
            if (this.pragma != null) {
                db.execSQL(this.pragma);
            } else {
                db.execSQL(DatabaseContrat.DEFAULT_PRAGMA);
            }
        }
    }

    public DBHelperBase setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    public int getDatabaseVersion() {
        return databaseVersion;
    }

    public DBHelperBase setDatabaseVersion(int databaseVersion) {
        this.databaseVersion = databaseVersion;
        return this;
    }

    public String getPragma() {
        return pragma;
    }

    public DBHelperBase setPragma(String pragma) {
        this.pragma = pragma;
        return this;
    }
}
