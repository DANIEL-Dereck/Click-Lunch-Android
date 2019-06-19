/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class PaymentActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x70;
    public static final String TAG = "PaymentActivity";

    private Button btn_activity_payment_back;
    private Button btn_activity_payment_validate;
    private TextView tv_payment_schedule;

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

        String hour = CartLocalStorage.getInstance().getHourString();
        String text = this.tv_payment_schedule.getText().toString();
        int limit = text.indexOf("%schedule%");
        text = text.replace("%schedule%", hour);

        Spannable spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new ForegroundColorSpan(
                        this.getResources().getColor(R.color.colorBlack)),
                0, (limit - 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(
                        this.getResources().getColor(R.color.colorOrangeText)),
                limit, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        this.tv_payment_schedule.setText(spannable);


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
        this.tv_payment_schedule = this.findViewById(R.id.tv_payment_schedule);
    }
}
