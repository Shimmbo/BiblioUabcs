package com.jimmy.uabcs.bibliouabcs.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.GeneralResponse;
import com.jimmy.uabcs.bibliouabcs.models.User;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jimmy.uabcs.bibliouabcs.utils.Utils.showProgress;
import static com.jimmy.uabcs.bibliouabcs.utils.Utils.startActivityHome;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.lastname)
    EditText lastname;
    @Bind(R.id.lastname2)
    EditText lastname2;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.confirmPassword)
    EditText confirmPassword;
    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.controlNumber)
    EditText controlNumber;
    @Bind(R.id.register_form)
    View registerForm;
    @Bind(R.id.register_progress)
    View registerProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLinkToLoginScreen)
    public void backToLogin() {
        Utils.startActivity(RegisterActivity.this, LoginActivity.class);
    }

    @OnClick(R.id.btn_register)
    public void register() {
        final int shortTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        User mUser = new User();
        mUser.setAddress(" ");
        mUser.setControlNumber(controlNumber.getText().toString());
        mUser.setEmail(email.getText().toString());
        mUser.setLastName_1(lastname.getText().toString());
        mUser.setLastName_2(lastname2.getText().toString());
        mUser.setName(name.getText().toString());
        mUser.setPhone(" ");
        mUser.setPassword(password.getText().toString());
        mUser.setConfirmPassword(confirmPassword.getText().toString());

        boolean cancelRegister = false;
        View focusView = null;


        if (cancelRegister) {
            // error in login
            focusView.requestFocus();
        } else {
            // show progress spinner, and start background task to login
            showProgress(true, registerForm, shortTime, registerProgress);

            LibraryService.register(mUser, new CustomSubscriber<GeneralResponse>() {
                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    showProgress(false, registerForm, shortTime, registerProgress);
                    Utils.showToast(getApplicationContext(), getString(R.string.error_register));
                }

                @Override
                public void onNext(GeneralResponse mGeneralResponse) {
                    super.onNext(mGeneralResponse);
                    showProgress(false, registerForm, shortTime, registerProgress);
                    if (mGeneralResponse.isSuccess()) {
                        Utils.showToast(getApplicationContext(), getString(R.string.register_success));
                        startActivityHome(RegisterActivity.this, LoginActivity.class);
                    } else {
                        Utils.showToast(getApplicationContext(), mGeneralResponse.getMessage());
                    }
                }
            });
        }
    }
}
