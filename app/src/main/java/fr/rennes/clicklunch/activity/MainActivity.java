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
import android.widget.TextView;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.utils.SharedPrefsUtils;

public class MainActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x00;
    public static final String TAG = "MainActivity";

    private Button btn_tmp_goto_shop_list;
    private TextView tv_create_new_account;
    private EditText et_connection_email;
    private EditText et_connection_password;

    @Override
    protected void initComponent()
    {
        Log.d(TAG, "initComponent: ");
        this.btn_tmp_goto_shop_list = findViewById(R.id.btn_tmp_goto_shop_detail);
        this.tv_create_new_account = findViewById(R.id.tv_create_new_account);
        this.et_connection_email = findViewById(R.id.et_connection_email);
        this.et_connection_password = findViewById(R.id.et_connection_password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);

        if (SharedPrefsUtils.getToekn() != null && !SharedPrefsUtils.getToekn().equals("")) {
            Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
            MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
        }

        this.et_connection_email.setText("");
        this.et_connection_password.setText("");

        this.btn_tmp_goto_shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn_tmp_goto_shop_list.onClick: ");

                Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
                MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
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
