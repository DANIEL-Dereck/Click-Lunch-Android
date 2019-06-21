/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.SharedPrefsUtils;
import fr.rennes.clicklunch.web_services.RetrofitBuilder;
import fr.rennes.clicklunch.web_services.ws_entity.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x00;
    public static final String TAG = "MainActivity";

    private Button btn_tmp_goto_shop_list;
    private TextView tv_create_new_account;
    private EditText et_connection_email;
    private EditText et_connection_password;
    private ProgressBar loader;

    @Override
    protected void initComponent()
    {
        Log.d(TAG, "initComponent: ");
        this.btn_tmp_goto_shop_list = this.findViewById(R.id.btn_tmp_goto_shop_detail);
        this.tv_create_new_account = this.findViewById(R.id.tv_create_new_account);
        this.et_connection_email = this.findViewById(R.id.et_connection_email);
        this.et_connection_password = this.findViewById(R.id.et_connection_password);
        this.loader = this.findViewById(R.id.main_loader);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (SharedPrefsUtils.getToken() != null && !SharedPrefsUtils.getToken().equals("")) {
            Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
            MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        if (SharedPrefsUtils.getToken() != null && !SharedPrefsUtils.getToken().equals("")) {
            Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
            MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
        }

        this.et_connection_email.setText("");
        this.et_connection_password.setText("");

        this.btn_tmp_goto_shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn_tmp_goto_shop_list.onClick: ");

                MainActivity.this.loader.setVisibility(View.VISIBLE);
                MainActivity.this.btn_tmp_goto_shop_list.setVisibility(View.GONE);

                Login login = new Login();
                login.setEmail(MainActivity.this.et_connection_email.getText().toString());
                login.setPassword(MainActivity.this.et_connection_password.getText().toString());

                RetrofitBuilder.getGsonClient().login(login).enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Log.d(TAG, "onResponse: ");

                        MainActivity.this.loader.setVisibility(View.GONE);
                        MainActivity.this.btn_tmp_goto_shop_list.setVisibility(View.VISIBLE);

                        if (response.code() == 200 || response.code() == 201) {
                            if (response.body() != null) {
                                SharedPrefsUtils.setToken(response.body().getToken());
                                SharedPrefsUtils.setUserId(response.body().getClient().getId());
                            }

                            Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
                            MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
                        } else {
                            Toast.makeText(
                                    MainActivity.this,
                                    MainActivity.this.getText(R.string.fail_sign_up),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");

                        MainActivity.this.loader.setVisibility(View.GONE);
                        MainActivity.this.btn_tmp_goto_shop_list.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        this.tv_create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "tv_create_new_account.onClick: ");
                Intent intent = new Intent(MainActivity.this, UserCreationActivity.class);
                MainActivity.this.startActivityForResult(intent, UserCreationActivity.MY_ACTIVITY_CODE);
            }
        });
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_main;
    }
}
