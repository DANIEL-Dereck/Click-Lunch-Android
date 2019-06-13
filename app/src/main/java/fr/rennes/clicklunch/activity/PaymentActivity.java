/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.AppUtil;

public class PaymentActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x70;
    public static final String TAG = "PaymentActivity";

    private Button btn_activity_payment_back;
    private Button btn_activity_payment_validate;

    @Override
    protected void onResume() {
        super.onResume();
        if (AppUtil.IS_EXIT_FLAG_RAISED) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.btn_activity_payment_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.btn_activity_payment_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
                AppUtil.IS_EXIT_FLAG_RAISED = true;
                PaymentActivity.this.startActivity(intent);

            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_payment;
    }

    @Override
    protected void initComponent() {
        this.btn_activity_payment_back = this.findViewById(R.id.btn_activity_payment_back);
        this.btn_activity_payment_validate = this.findViewById(R.id.btn_activity_payment_validate);
    }
}
