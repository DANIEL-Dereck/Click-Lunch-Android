package fr.rennes.clicklunch;

import android.app.Application;
import android.content.Context;

import fr.rennes.clicklunch.database.DatabaseHelper;
import fr.rennes.database.Manager.DatabaseManager;


public class App extends Application {
    private static Context context;
    private static DatabaseHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper(context);
        DatabaseManager.initInstance(dbHelper);
    }

    public static Context getContext() {
        return context;
    }
}

