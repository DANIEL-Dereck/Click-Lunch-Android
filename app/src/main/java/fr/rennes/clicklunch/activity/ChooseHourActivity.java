/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class ChooseHourActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x60;
    public static final String TAG = "ChooseHourActivity";

    public String[] hours = {"12","13"};
    public String[] minutes = {"0", "15", "30", "45"};

    private TextView tv_choose_hour_next_schedule;
    private Button btn_activity_choose_hour_change_hour;
    private Button btn_activity_choose_hour_back;
    private Button btn_activity_choose_hour_validate;
    private ConstraintLayout cl_activity_choose_hour_selector;
    private Spinner spi_activity_choose_hour_hour;
    private Spinner spi_activity_choose_hour_minutes;

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

        ArrayAdapter<CharSequence> adapterHour = ArrayAdapter.createFromResource(this, R.array.choose_hour, android.R.layout.simple_spinner_item);
        adapterHour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spi_activity_choose_hour_hour.setAdapter(adapterHour);

        ArrayAdapter<CharSequence> adapterMinutes = ArrayAdapter.createFromResource(this, R.array.choose_minutes, android.R.layout.simple_spinner_item);
        adapterMinutes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spi_activity_choose_hour_minutes.setAdapter(adapterMinutes);

        ChooseHourActivity.this.cl_activity_choose_hour_selector.setVisibility(View.GONE);

        String hour = "12:00";
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
                if (ChooseHourActivity.this.cl_activity_choose_hour_selector.getVisibility() == View.GONE) {
                    ChooseHourActivity.this.cl_activity_choose_hour_selector.setVisibility(View.VISIBLE);
                } else {
                    ChooseHourActivity.this.cl_activity_choose_hour_selector.setVisibility(View.GONE);
                }
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

                if (ChooseHourActivity.this.spi_activity_choose_hour_hour.getVisibility() == View.VISIBLE &&
                        ChooseHourActivity.this.spi_activity_choose_hour_minutes.getVisibility() == View.VISIBLE) {
                    CartLocalStorage.getInstance().setRecuperationHour(
                            ChooseHourActivity.this.spi_activity_choose_hour_hour.getSelectedItem().toString(),
                            ChooseHourActivity.this.spi_activity_choose_hour_minutes.getSelectedItem().toString()
                    );
                } else {
                    CartLocalStorage.getInstance().setRecuperationHour("12","30");
                }

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
        this.cl_activity_choose_hour_selector = this.findViewById(R.id.cl_activity_choose_hour_selector);
        this.spi_activity_choose_hour_hour = this.findViewById(R.id.spi_activity_choose_hour_hour);
        this.spi_activity_choose_hour_minutes = this.findViewById(R.id.spi_activity_choose_hour_minutes);
    }
}
