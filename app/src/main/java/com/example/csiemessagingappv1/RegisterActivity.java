package com.example.csiemessagingappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    // Firebase related fields
    FirebaseAuth mAuth;
    DatabaseReference reference;
    //

    private androidx.appcompat.widget.Toolbar mToolbar;
    private TextInputLayout mDisplayName;
    private Button mCreateBtn;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    //A progress bar for registration
    private ProgressDialog mRegProgress;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /// Setting the toolbar
        mToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.register_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Account Creation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ///

        mRegProgress = new ProgressDialog(this);

        //Firebase authentification code
        mAuth = FirebaseAuth.getInstance();
        //
        mCreateBtn = (Button) findViewById(R.id.reg_create_btn);
        mDisplayName = (TextInputLayout) findViewById(R.id.reg_display_name);
        mEmail = (TextInputLayout) findViewById(R.id.reg_email);
        mPassword = (TextInputLayout) findViewById((R.id.reg_password));

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String display_name = mDisplayName.getEditText().getText().toString();
                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();

                //We check if the fields are null (you cannot proceed if they are)
                if(!TextUtils.isEmpty(display_name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && password.length()>=6)
                {
                    mRegProgress.setTitle("Registering new account");
                    mRegProgress.setMessage("Please wait for your account to be created...");
                    mRegProgress.show();
                    register_user(display_name, email, password); //we start the registration process
                }
                else if(TextUtils.isEmpty(display_name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || password.length()<6){
                    if(TextUtils.isEmpty(display_name))
                    {
                        Toast.makeText(RegisterActivity.this, "The Field DisplayName cannot be empty.",Toast.LENGTH_LONG).show();
                    }
                    if(TextUtils.isEmpty(email))
                    {
                        Toast.makeText(RegisterActivity.this, "The Field Email cannot be empty.",Toast.LENGTH_LONG).show();
                    }
                    if(TextUtils.isEmpty(password) || password.length()<6)
                    {
                        Toast.makeText(RegisterActivity.this, "The Field Password cannot be empty.",Toast.LENGTH_LONG).show();
                    }
                    if(password.length()<6)  ///!!!!!!! FIREBASE AUTHENTIFICATION WON'T WORK IF PASSWORD LENGTH < 6
                    {
                        Toast.makeText(RegisterActivity.this, "PASSWORD MUST BE AT LEAST 6 CHARACTERS LONG!",Toast.LENGTH_LONG).show();
                    }

                }
                //
            }
        });

    }

    /// Method for registration
    private void register_user(final String display_name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            assert firebaseUser != null;
                            String userId = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("User").child(userId);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userId);
                            hashMap.put("username", display_name);
                            hashMap.put("imageURL", "default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        mRegProgress.dismiss(); //Dispare bara de progres
                                        ////!!! Daca campul de email nu este chiar un email, nu va functiona!
                                        Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                                        //Daca a reusit inregistrarea, ne intoarcem la activitatea principala
                                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(mainIntent);
                                        finish();
                                    }
                                    else
                                    {
                                        mRegProgress.hide(); //We hide the progress bar if the registration is not successful
                                        Toast.makeText(RegisterActivity.this, "Error while registering. Please check if field formats are correct.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                    }
                });

    }
}
