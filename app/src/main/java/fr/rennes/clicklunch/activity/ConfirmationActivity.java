/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.clicklunch.R;

public class ConfirmationActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x80;
    public static final String TAG = "ConfirmationActivity";

    private Button btn_activity_confirmation_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.btn_activity_confirmation_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmationActivity.this.finish();
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_confirmation;
    }

    @Override
    protected void initComponent() {
        this.btn_activity_confirmation_finish = this.findViewById(R.id.btn_activity_confirmation_finish);
    }
}
