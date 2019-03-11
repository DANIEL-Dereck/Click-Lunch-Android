/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.clicklunch.R;

public class MainActivity extends Activity {

    public static final int MY_ACTIVITY_CODE = 0; // Activity code

    private Button btn_tmp_goto_shop_list;
    private Button btn_tmp_goto_shop_detail;

    public static Class<?> cls;
    public static int acCode;

    private void initComponent()
    {
        this.btn_tmp_goto_shop_list = findViewById(R.id.btn_tmp_goto_shop_list);
        this.btn_tmp_goto_shop_detail = findViewById(R.id.btn_tmp_goto_shop_detail);
    }

    private void goToView(Button btn, Class<?> clazz, int activityCode)
    {
        cls = clazz;
        acCode = activityCode;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.cls);
                MainActivity.this.startActivityForResult(intent, acCode);
            }
        } );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
//
//        this.goToView(this.btn_tmp_goto_shop_list, ShopListActivity.class, ShopListActivity.MY_ACTIVITY_CODE);
//        this.goToView(this.btn_tmp_goto_shop_detail, ShopDetailActivity.class, ShopDetailActivity.MY_ACTIVITY_CODE);

        this.btn_tmp_goto_shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
                MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
            }
        } );

        this.btn_tmp_goto_shop_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShopDetailActivity.class);
                MainActivity.this.startActivityForResult(intent, ShopDetailActivity.MY_ACTIVITY_CODE);
            }
        });
    }
}
