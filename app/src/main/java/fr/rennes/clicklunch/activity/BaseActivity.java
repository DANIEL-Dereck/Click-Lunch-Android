/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Base of all activities.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        this.setContentView(getContentView());
        super.onCreate(savedInstanceState);
        this.initComponent();
        this.initMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        return false;
    }

    /**
     * Init tool bar.
     */
    private void initToolBar() {
        Log.d(TAG, "initToolBar: ");
    }

    /**
     * Init menu.
     */
    protected void initMenu() {
        Log.d(TAG, "initMenu: ");
        this.initToolBar();
    }

    // Abstract methods;

    /**
     * Get contentView.
     * @return id of view.
     */
    public abstract int getContentView();

    /**
     * Init component use in activity.
     */
    protected abstract void initComponent();
}
