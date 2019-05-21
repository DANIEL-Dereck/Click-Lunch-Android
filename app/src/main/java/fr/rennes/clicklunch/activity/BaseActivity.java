package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import fr.rennes.clicklunch.App;
import fr.rennes.clicklunch.R;

/**
 * Base of all activities.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = "BaseActivity";

    /**
     * Navigation view.
     */
    private NavigationView navigationView;

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
     * OnNavigationItemSelected.
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: ");
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

        return true;
    }

    /**
     * Init tool bar.
     */
    private void initToolBar() {
        Log.d(TAG, "initToolBar: ");
        this.navigationView = this.findViewById(R.id.nav_view);
    }

    /**
     * Init menu.
     */
    protected void initMenu() {
        Log.d(TAG, "initMenu: ");
        this.initToolBar();
        this.navigationView.setNavigationItemSelectedListener(this);
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
