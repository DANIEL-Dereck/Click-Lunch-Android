package fr.rennes.clicklunch.utils;

import android.location.Location;

public class GPSTracker {

    public static Location getNewLocation(String provider, double latitude, double longitude) {
        Location location = new Location(provider);
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        return location;
    }

    public static Location getCurrentLocation() {
        return getNewLocation("current", 0, 0);
    }

    public static String getDistance(Location currentLocation, Location destinationLocation)
    {
        String result = "";

        if (currentLocation != null  && destinationLocation != null) {
            int distanceBetween = (int)currentLocation.distanceTo(destinationLocation);

            if (distanceBetween / 1000 >= 1) {
                result = (distanceBetween / 1000) + "," + (distanceBetween % 1000) + "km";
            } else {
                result = (int)currentLocation.distanceTo(destinationLocation) + "m";
            }
        }

        return result;
    }
}
