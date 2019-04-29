package fr.rennes.clicklunch.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import fr.rennes.clicklunch.App;

public class PermissionUtils {
    public static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String COARSE_LOCATION =  Manifest.permission.ACCESS_COARSE_LOCATION;

    /**
     * get permision
     */
    public static boolean getPermission(String permision) {
        boolean result = false;

        if (ActivityCompat.checkSelfPermission(App.getAppContext(), permision) == PackageManager.PERMISSION_GRANTED) {
            result = true;
        }

        return result;
    }
}
