package fr.rennes.database.Manager;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.rennes.database.Contrat.DatabaseContrat;
import fr.rennes.database.Helper.DBHelperBase;

public class DatabaseManager {
    private final String LOGTAG = this.getClass().toString();
    private static final String LOG = "DatabaseManager";

    private Integer mOpenCounter = 0;

    private  static DatabaseManager instance;
    private static DBHelperBase mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public static synchronized void initInstance(DBHelperBase helper){
        Log.d(LOG, DatabaseContrat.INITINSTANCE + DatabaseManager.class.toString());
        if (instance == null)
        {
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance() {
        Log.d(LOG, DatabaseContrat.GETINSTANCE + DatabaseManager.class.toString());
        if (instance == null) {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                    " is not initialized, call initInstance(..) method first.");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
        Log.d(LOGTAG, DatabaseContrat.OPENDB);
        mOpenCounter += 1;
        if (mOpenCounter == 1) {
            mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDatabase(){
        Log.d(LOGTAG, DatabaseContrat.CLOSEDB);
        mOpenCounter -= 1;
        if (mOpenCounter == 0){
            mDatabase.close();
        }
    }
}
