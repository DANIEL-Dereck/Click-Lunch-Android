/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 01/03/2019
 *************************************/
package fr.rennes.clicklunch.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.rennes.clicklunch.R;

public class UserCreationActivity extends BaseActivity {

    // Static final attributes.
    public static final int MY_ACTIVITY_CODE = 0x10;
    public static final String TAG = "UserCreationActivity";

    // Fields
    private EditText et_user_creation_lastname;
    private EditText et_user_creation_firstname;
    private EditText et_user_creation_email;
    private EditText et_user_creation_phone;
    private EditText et_user_creation_password;
    private EditText et_user_creation_password_confirmation;

    // Fields layout.
    private TextInputLayout til_user_creation_lastname;
    private TextInputLayout til_user_creation_firstname;
    private TextInputLayout til_user_creation_email;
    private TextInputLayout til_user_creation_phone;
    private TextInputLayout til_user_creation_password;
    private TextInputLayout til_user_creation_password_confirmation;

    // Validation button
    private Button btn_user_creation_save;

    @Override
    protected void initComponent() {
        Log.d(TAG, "initComponent: ");
        this.et_user_creation_lastname = this.findViewById(R.id.et_user_creation_lastname);
        this.et_user_creation_firstname = this.findViewById(R.id.et_user_creation_firstname);
        this.et_user_creation_email = this.findViewById(R.id.et_user_creation_email);
        this.et_user_creation_phone = this.findViewById(R.id.et_user_creation_phone);
        this.et_user_creation_password = this.findViewById(R.id.et_user_creation_password);
        this.et_user_creation_password_confirmation = this.findViewById(R.id.et_user_creation_password_confirmation);

        this.til_user_creation_lastname = this.findViewById(R.id.til_user_creation_lastname);
        this.til_user_creation_firstname = this.findViewById(R.id.til_user_creation_firstname);
        this.til_user_creation_email = this.findViewById(R.id.til_user_creation_email);
        this.til_user_creation_phone = this.findViewById(R.id.til_user_creation_phone);
        this.til_user_creation_password = this.findViewById(R.id.til_user_creation_password);
        this.til_user_creation_password_confirmation = this.findViewById(R.id.til_user_creation_password_confirmation);

        this.btn_user_creation_save = this.findViewById(R.id.btn_user_creation_save);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        this.resetText();




        this.et_user_creation_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_password.setError("Enter à password");
                } else {
                    UserCreationActivity.this.til_user_creation_password.setError(null);

                    if (!s.toString().equals(UserCreationActivity.this.et_user_creation_password_confirmation.getText().toString())
                            && !UserCreationActivity.this.et_user_creation_password_confirmation.getText().toString().equals("")) {
                        UserCreationActivity.this.til_user_creation_password_confirmation.setError("not same password");
                    } else {
                        UserCreationActivity.this.til_user_creation_password_confirmation.setError(null);
                    }
                }
            }
        });

        // Confirmation password,
        this.et_user_creation_password_confirmation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(UserCreationActivity.this.et_user_creation_password.getText().toString())) {
                    UserCreationActivity.this.til_user_creation_password_confirmation.setError("not same password");
                } else {
                    UserCreationActivity.this.til_user_creation_password_confirmation.setError(null);
                }
            }
        });

        this.btn_user_creation_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_user_creation;
    }

    private void resetText() {
        this.et_user_creation_lastname.setText("");
        this.et_user_creation_firstname.setText("");
        this.et_user_creation_email.setText("");
        this.et_user_creation_phone.setText("");
        this.et_user_creation_password.setText("");
        this.et_user_creation_password_confirmation.setText("");
    }
}
