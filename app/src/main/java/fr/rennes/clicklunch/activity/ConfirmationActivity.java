/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.CartLocalStorage;

public class ConfirmationActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x80;
    public static final String TAG = "ConfirmationActivity";

    private TextView tv_order_number;
    private TextView tv_order_detail;
    private Button btn_activity_confirmation_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String orderNumber = "XXXXXXXXX";
        String text = this.tv_order_number.getText().toString().replace("%num%", orderNumber);
        this.tv_order_number.setText(text);

        String hour = CartLocalStorage.getInstance().getHourString();
        String shopName = CartLocalStorage.getInstance().getShopName();
        text = this.tv_order_detail.getText().toString();
        int positionShopName = text.indexOf("%shopName");
        text = text.replace("%shopName%", shopName);
        int positionSchedule = text.indexOf("%schedule%");
        text = text.replace("%schedule%", hour);

        Spannable spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new ForegroundColorSpan(this.getResources().getColor(R.color.colorBlack)),0, (positionShopName - 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(this.getResources().getColor(R.color.colorOrangeText)), positionShopName, (positionShopName + shopName.length()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(this.getResources().getColor(R.color.colorBlack)),(positionShopName + shopName.length() + 1) , (positionSchedule - 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(this.getResources().getColor(R.color.colorOrangeText)), positionSchedule, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        this.tv_order_detail.setText(spannable);

        this.btn_activity_confirmation_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartLocalStorage.getInstance().clear();
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
        this.tv_order_detail = this.findViewById(R.id.tv_order_detail);
        this.tv_order_number = this.findViewById(R.id.tv_order_number);
    }
}
