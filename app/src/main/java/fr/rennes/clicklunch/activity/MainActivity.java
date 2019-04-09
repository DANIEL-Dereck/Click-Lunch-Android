/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 22/02/2019
 *************************************/

package fr.rennes.clicklunch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.clicklunch.R;

public class MainActivity extends BaseActivity {
    public static final int MY_ACTIVITY_CODE = 0; // Activity code

    private Button btn_tmp_goto_shop_list;

    private void initComponent()
    {
        this.btn_tmp_goto_shop_list = findViewById(R.id.btn_tmp_goto_shop_detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        this.initMenu();

        this.btn_tmp_goto_shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShopListActivity.class);
                MainActivity.this.startActivityForResult(intent, ShopListActivity.MY_ACTIVITY_CODE);
            }
        } );
    }
}
