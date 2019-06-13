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

public class ChooseHourActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x60;
    public static final String TAG = "ChooseHourActivity";

    private TextView tv_choose_hour_next_schedule;
    private Button btn_activity_choose_hour_change_hour;
    private Button btn_activity_choose_hour_back;
    private Button btn_activity_choose_hour_validate;

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

        // TODO: get the first free schedule.
        String hour = "12:30";
        String text = this.tv_choose_hour_next_schedule.getText().toString();
        int limit = text.indexOf("%schedule%");
        text = text.replace("%schedule%", hour);

        Spannable spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new ForegroundColorSpan(
                        this.getResources().getColor(R.color.colorBlack)),
                0, (limit - 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(
                this.getResources().getColor(R.color.colorOrangeText)),
                limit, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        this.tv_choose_hour_next_schedule.setText(spannable);

        this.btn_activity_choose_hour_change_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: insert code to prompt something to change hour.
            }
        });

        this.btn_activity_choose_hour_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.btn_activity_choose_hour_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseHourActivity.this, PaymentActivity.class);
                ChooseHourActivity.this.startActivity(intent);

            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_choose_hour;
    }

    @Override
    protected void initComponent() {
        this.tv_choose_hour_next_schedule = this.findViewById(R.id.tv_choose_hour_next_schedule);
        this.btn_activity_choose_hour_change_hour = this.findViewById(R.id.btn_activity_choose_hour_change_hour);
        this.btn_activity_choose_hour_validate = this.findViewById(R.id.btn_activity_choose_hour_validate);
        this.btn_activity_choose_hour_back = this.findViewById(R.id.btn_activity_choose_hour_back);
    }
}
