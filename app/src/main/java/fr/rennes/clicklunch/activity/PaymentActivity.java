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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.AppUtil;
import fr.rennes.clicklunch.utils.CartLocalStorage;
import fr.rennes.clicklunch.utils.SharedPrefsUtils;
import fr.rennes.clicklunch.web_services.ConverterFactory;
import fr.rennes.clicklunch.web_services.RetrofitBuilder;
import fr.rennes.clicklunch.web_services.ws_entity.RetrofitOrder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x70;
    public static final String TAG = "PaymentActivity";

    private Button btn_activity_payment_back;
    private Button btn_activity_payment_validate;
    private TextView tv_payment_schedule;
    private ConstraintLayout cl_payment;
    private ProgressBar payment_loader;

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

        if (AppUtil.PAYMENT_ENABLE) {
            this.cl_payment.setVisibility(View.VISIBLE);
        } else {
            this.cl_payment.setVisibility(View.GONE);
        }

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

                PaymentActivity.this.btn_activity_payment_validate.setVisibility(View.GONE);
                PaymentActivity.this.btn_activity_payment_back.setVisibility(View.GONE);
                PaymentActivity.this.payment_loader.setVisibility(View.VISIBLE);

                RetrofitBuilder.getGsonClient().passOrder(
                        CartLocalStorage.getInstance().getShopId(),
                        SharedPrefsUtils.getUserId(),
                        CartLocalStorage.getInstance().cartToRetrofitOrder(),
                        SharedPrefsUtils.getToken()
                ).enqueue(new Callback<RetrofitOrder.RetrofitOrderResult>() {
                    @Override
                    public void onResponse(Call<RetrofitOrder.RetrofitOrderResult> call, Response<RetrofitOrder.RetrofitOrderResult> response) {
                        Log.d(TAG, "onResponse: ");

                        if (response.code() == 200 || response.code() == 201) {
                            CartLocalStorage.getInstance().setOrderNumber(response.body().getNumber());
                            Intent intent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
                            AppUtil.IS_EXIT_FLAG_RAISED = true;
                            PaymentActivity.this.startActivity(intent);
                        } else {
                            Toast.makeText(
                                    PaymentActivity.this,
                                    PaymentActivity.this.getText(R.string.fail_pass_order),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        PaymentActivity.this.btn_activity_payment_validate.setVisibility(View.VISIBLE);
                        PaymentActivity.this.btn_activity_payment_back.setVisibility(View.VISIBLE);
                        PaymentActivity.this.payment_loader.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<RetrofitOrder.RetrofitOrderResult> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");

                        PaymentActivity.this.btn_activity_payment_validate.setVisibility(View.VISIBLE);
                        PaymentActivity.this.btn_activity_payment_back.setVisibility(View.VISIBLE);
                        PaymentActivity.this.payment_loader.setVisibility(View.GONE);
                    }
                });
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
        this.cl_payment = this.findViewById(R.id.cl_payment);
        this.payment_loader = this.findViewById(R.id.payment_loader);
    }
}
