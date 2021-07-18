package com.example.csiemessagingappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    //Firebase related fields
    private FirebaseAuth mAuth;
    //

    private androidx.appcompat.widget.Toolbar mToolbar;
    private TextInputLayout mLoginEmail;
    private TextInputLayout mLoginPassword;
    private Button mLoginBtn;
    private Button mSendReportBtn;
    private ProgressDialog mLoginProgress;

    ///

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox rem_loginInfo;

    private static final String PREF_NAME = "preferences";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Setting the toolbar
        mToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Log In");
        // Progress bar
        mLoginProgress = new ProgressDialog(this);
        //
        mLoginEmail =  (TextInputLayout) findViewById(R.id.login_email);
        mLoginPassword = (TextInputLayout) findViewById(R.id.login_password);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mSendReportBtn = (Button) findViewById(R.id.sendfeedback_btn);



        //// Shared preferences - remmembering username & password at login prompt
        //// when closing the application or logging out

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        mLoginEmail = (TextInputLayout) findViewById(R.id.login_email);
        mLoginPassword = (TextInputLayout) findViewById(R.id.login_password);

        rem_loginInfo = (CheckBox) findViewById(R.id.remember_checkbox);

        if(sharedPreferences.getBoolean(KEY_REMEMBER, false))
        {
            rem_loginInfo.setChecked(true);
        }
        else
        {
            rem_loginInfo.setChecked(false);
        }

        mLoginEmail.getEditText().setText(sharedPreferences.getString(KEY_USERNAME, ""));
        mLoginPassword.getEditText().setText(sharedPreferences.getString(KEY_PASSWORD, ""));

        mLoginEmail.getEditText().addTextChangedListener((TextWatcher) this);
        mLoginPassword.getEditText().addTextChangedListener((TextWatcher) this);
        rem_loginInfo.setOnCheckedChangeListener(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mLoginEmail.getEditText().getText().toString();
                String password = mLoginPassword.getEditText().getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
                {
                    mLoginProgress.setTitle("You are being logged in");
                    mLoginProgress.setMessage("Please wait to be logged in...");
                    mLoginProgress.setCanceledOnTouchOutside(false);
                    mLoginProgress.show();

                    loginUser(email, password);
                }
                else
                {
                    if(TextUtils.isEmpty(email))
                    {
                        Toast.makeText(LoginActivity.this, "The Field Email cannot be empty.",Toast.LENGTH_LONG).show();
                    }
                    if(TextUtils.isEmpty(password))
                    {
                        Toast.makeText(LoginActivity.this, "The Field Password cannot be empty.",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mSendReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_completed = mLoginEmail.getEditText().getText().toString();
                String password_completed = mLoginPassword.getEditText().getText().toString();

                //Code for passing an object to the next activity
                Intent passUserObject = new Intent(LoginActivity.this, FeedbackForm.class);
                User userObject;
                //Bundle bundle = new Bundle();

                if(email_completed.matches("") || password_completed.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill the user info before submitting a report!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Code for passing an object to the next activity
                    userObject = new User(password_completed, email_completed);
                    passUserObject.putExtra("objectToPass", userObject);
                    startActivity(passUserObject);
                }

            }
        });
    }
    //Log In method
    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) //if the user has signed in
                {
                    mLoginProgress.dismiss(); //dismiss the progress dialogue

                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    //// mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainIntent);
                    finish();
                }
                else
                {
                    mLoginProgress.hide(); // Hide the progress bar if not successful
                    Toast.makeText(LoginActivity.this, "Cannot sign in. Please check if the data is correct.", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    //// For shared preferences (remember login info)

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePreferences();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    managePreferences();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void managePreferences() {
        if(rem_loginInfo.isChecked())
        {
            editor.putString(KEY_USERNAME, mLoginEmail.getEditText().getText().toString().trim());
            editor.putString(KEY_PASSWORD, mLoginPassword.getEditText().getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        }
        else
        {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASSWORD);
            editor.remove(KEY_USERNAME);
            editor.apply();
        }
    }

}
