package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.util.Log;

import fr.rennes.clicklunch.App;
import fr.rennes.clicklunch.R;

public class UserCreationActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x10;
    public static final String TAG = "UserCreationActivity";

    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_user_creation;
    }
}
