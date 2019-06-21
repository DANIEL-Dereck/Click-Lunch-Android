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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import fr.rennes.clicklunch.R;
import fr.rennes.clicklunch.entities.Client;
import fr.rennes.clicklunch.utils.ValidatorUtils;
import fr.rennes.clicklunch.utils.SharedPrefsUtils;
import fr.rennes.clicklunch.web_services.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private ProgressBar user_creation_loader;

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
        this.user_creation_loader = this.findViewById(R.id.user_creation_loader);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        this.resetText();

        this.et_user_creation_lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_lastname.setError(
                            UserCreationActivity.this.getString(R.string.validation_lastname_empty));
                } else if (ValidatorUtils.isNameValid(s.toString())) {
                    UserCreationActivity.this.til_user_creation_lastname.setError(
                            UserCreationActivity.this.getString(R.string.validation_lastname_bad_schema));
                } else if (s.toString().length() < 3 || s.toString().length() > 100) {
                    UserCreationActivity.this.til_user_creation_lastname.setError(
                            UserCreationActivity.this.getString(R.string.validation_lastname_bad_size));
                } else {
                    UserCreationActivity.this.til_user_creation_lastname.setError(null);
                }
            }
        });

        this.et_user_creation_firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_firstname.setError(
                            UserCreationActivity.this.getString(R.string.validation_firstname_empty));
                } else if (ValidatorUtils.isNameValid(s.toString())) {
                    UserCreationActivity.this.til_user_creation_firstname.setError(
                            UserCreationActivity.this.getString(R.string.validation_firstname_bad_schema));
                } else if (s.toString().length() < 3 || s.toString().length() > 100) {
                    UserCreationActivity.this.til_user_creation_firstname.setError(
                            UserCreationActivity.this.getString(R.string.validation_firstname_bad_size));
                } else {
                    UserCreationActivity.this.til_user_creation_firstname.setError(null);
                }
            }
        });

        this.et_user_creation_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_email.setError(
                            UserCreationActivity.this.getString(R.string.validation_email_empty));
                } else if (ValidatorUtils.isEmailValid(s.toString())) {
                    UserCreationActivity.this.til_user_creation_email.setError(
                            UserCreationActivity.this.getString(R.string.validation_email_bad_schema));
                } else {
                    UserCreationActivity.this.til_user_creation_email.setError(null);
                }
            }
        });

        this.et_user_creation_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_phone.setError(
                            UserCreationActivity.this.getString(R.string.validation_phone_empty));
                } else if (ValidatorUtils.isPhoneValid(s.toString())) {
                    UserCreationActivity.this.til_user_creation_phone.setError(
                            UserCreationActivity.this.getString(R.string.validation_phone_bad_size));
                } else {
                    UserCreationActivity.this.til_user_creation_phone.setError(null);
                }
            }
        });

        this.et_user_creation_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    UserCreationActivity.this.til_user_creation_password.setError(
                            UserCreationActivity.this.getString(R.string.validation_password_empty));
                } else if (s.toString().length() < 5 || s.toString().length() > 1024) {
                    UserCreationActivity.this.til_user_creation_password.setError(
                            UserCreationActivity.this.getString(R.string.validation_password_bas_size));
                } else {
                    UserCreationActivity.this.til_user_creation_password.setError(null);

                    if (!s.toString().equals(UserCreationActivity.this.et_user_creation_password_confirmation.getText().toString())
                            || UserCreationActivity.this.et_user_creation_password_confirmation.getText().toString().equals("")) {
                        UserCreationActivity.this.til_user_creation_password_confirmation.setError(
                                UserCreationActivity.this.getString(R.string.validation_password_not_same));
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
                    UserCreationActivity.this.til_user_creation_password_confirmation.setError(
                            UserCreationActivity.this.getString(R.string.validation_password_not_same));
                } else {
                    UserCreationActivity.this.til_user_creation_password_confirmation.setError(null);
                }
            }
        });

        this.btn_user_creation_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {

                    UserCreationActivity.this.btn_user_creation_save.setVisibility(View.GONE);
                    UserCreationActivity.this.user_creation_loader.setVisibility(View.VISIBLE);

                    Client client = new Client();
                    client.setFirstname(UserCreationActivity.this.et_user_creation_firstname.getText().toString());
                    client.setLastname(UserCreationActivity.this.et_user_creation_lastname.getText().toString());
                    client.setEmail(UserCreationActivity.this.et_user_creation_email.getText().toString());
                    client.setPhoneNumber(UserCreationActivity.this.et_user_creation_phone.getText().toString());
                    client.setPassword(UserCreationActivity.this.et_user_creation_password.getText().toString());

                    Date currentTime = Calendar.getInstance().getTime();
                    client.setCreatedAt(currentTime);
                    client.setUpdatedAt(currentTime);

                    RetrofitBuilder.getGsonClient().addUser(client).enqueue(new Callback<Client>() {
                        @Override
                        public void onResponse(Call<Client> call, Response<Client> response) {
                            Log.d(TAG, "onResponse: ");
                            if (response.code() == 200 || response.code() == 201) {
                                SharedPrefsUtils.setToken(response.headers().get("X-Auth-Token"));
                                SharedPrefsUtils.setUserId(response.body().getId());
                                finish();
                            } else {
                                Toast.makeText(
                                        UserCreationActivity.this,
                                        UserCreationActivity.this.getText(R.string.fail_sign_up),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            UserCreationActivity.this.btn_user_creation_save.setVisibility(View.VISIBLE);
                            UserCreationActivity.this.user_creation_loader.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<Client> call, Throwable t) {
                            Log.d(TAG, "onFailure: " + call.toString());

                            Toast.makeText(
                                    UserCreationActivity.this,
                                    UserCreationActivity.this.getText(R.string.fail_sign_up),
                                    Toast.LENGTH_SHORT
                            ).show();

                            UserCreationActivity.this.btn_user_creation_save.setVisibility(View.VISIBLE);
                            UserCreationActivity.this.user_creation_loader.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getContentView() {
        Log.d(TAG, "getContentView: ");
        return R.layout.activity_user_creation;
    }

    private boolean validateForm() {
        boolean result = false;
        String lastname = this.et_user_creation_lastname.getText().toString();
        String firstname = this.et_user_creation_firstname.getText().toString();
        String email = this.et_user_creation_email.getText().toString();
        String phone = this.et_user_creation_phone.getText().toString();
        String password = this.et_user_creation_password.getText().toString();
        String confirmationPassword = this.et_user_creation_password_confirmation.getText().toString();

        if (lastname.equals("")) {
            this.til_user_creation_lastname.setError(this.getString(R.string.validation_lastname_empty));
        } else if (ValidatorUtils.isNameValid(lastname)) {
            this.til_user_creation_lastname.setError(this.getString(R.string.validation_lastname_bad_schema));
        } else if (lastname.length() < 3 || lastname.length() > 100) {
            this.til_user_creation_lastname.setError(this.getString(R.string.validation_lastname_bad_size));
        } else {
            this.til_user_creation_lastname.setError(null);
        }

        if (firstname.equals("")) {
            this.til_user_creation_firstname.setError(this.getString(R.string.validation_firstname_empty));
        } else if (ValidatorUtils.isNameValid(firstname)) {
            this.til_user_creation_firstname.setError(this.getString(R.string.validation_firstname_bad_schema));
        } else if (firstname.length() < 3 || firstname.length() > 100) {
            this.til_user_creation_firstname.setError(this.getString(R.string.validation_firstname_bad_size));
        } else {
            this.til_user_creation_firstname.setError(null);
        }

        if (email.equals("")) {
            this.til_user_creation_email.setError(this.getString(R.string.validation_email_empty));
        } else if (ValidatorUtils.isEmailValid(email)) {
            this.til_user_creation_email.setError(this.getString(R.string.validation_email_bad_schema));
        } else {
            this.til_user_creation_email.setError(null);
        }

        if (phone.equals("")) {
            this.til_user_creation_phone.setError(this.getString(R.string.validation_phone_empty));
        } else if (ValidatorUtils.isPhoneValid(phone)) {
            this.til_user_creation_phone.setError(this.getString(R.string.validation_phone_bad_size));
        } else {
            this.til_user_creation_phone.setError(null);
        }

        if (password.equals("")) {
            this.til_user_creation_password.setError(this.getString(R.string.validation_password_empty));
        } else if (password.length() < 5 || password.length() > 1024) {
            this.til_user_creation_password.setError(this.getString(R.string.validation_password_bas_size));
        } else {
            this.til_user_creation_password.setError(null);
        }

        if (confirmationPassword.equals("")) {
            this.til_user_creation_password_confirmation.setError(this.getString(R.string.validation_password_confirmation_empty));
        } else if (!confirmationPassword.equals(password)) {
            this.til_user_creation_password_confirmation.setError(this.getString(R.string.validation_password_not_same));
        } else {
            this.til_user_creation_password_confirmation.setError(null);
        }

        if (
                this.til_user_creation_lastname.getError() == null &&
                this.til_user_creation_firstname.getError() == null &&
                this.til_user_creation_email.getError() == null &&
                this.til_user_creation_phone.getError() == null &&
                this.til_user_creation_password.getError() == null &&
                this.til_user_creation_password_confirmation.getError() == null
        ) {
            result = true;
        }

        return result;
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
