package com.example.csiemessagingappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {


    ///!!!! Firebase Google account for the project:
    //// Email: damproject2019@gmail.com        Password: parolaproiect8


    ///Firebase connection related fields
    FirebaseUser firebaseUser;
    //

    private Button mRegButton;
    private Button mLoginButton;
    private androidx.appcompat.widget.Toolbar mToolbar;
    public static ImageView mainLogo;

    @Override
    protected void onStart() {
        super.onStart();

        //Authentification through Firebase
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //Check if user is null
        if(firebaseUser !=null)
        {
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        mRegButton = (Button) findViewById(R.id.start_reg_btn);
        mLoginButton = (Button) findViewById(R.id.start_login_button);
        mainLogo = (ImageView) findViewById(R.id.logo_main);

        mRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reg_intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(reg_intent);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(login_intent);
            }
        });


        //For loading the logo from the network we call the class we've implemented (LoadInternetImage class)
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new LoadInternetImage().execute("https://i.imgur.com/kDpK9Rp.png");
            }
        });
    }
}


