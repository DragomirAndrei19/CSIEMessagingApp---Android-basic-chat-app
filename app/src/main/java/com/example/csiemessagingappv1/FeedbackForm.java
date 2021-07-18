package com.example.csiemessagingappv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public User receivedUser; // Object we received in previous activity
    public Button sendReportBtn;
    public Button updateReportBtn;
    public Button deleteReportBtn;
    public Button loadDataForEditBtn;
    private androidx.appcompat.widget.Toolbar mToolbar; //Toolbar
    public TextView selectCountryTv;
    public Spinner countrySelectSpinner;
    String selectedCountry;
    EditText email_et;
    EditText password_et;
    EditText idForUpdate_et;
    EditText problem_details_et;

    // Database SQLite
    DatabaseHelper bugReportsDb;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

        /// SQLite database

        bugReportsDb = new DatabaseHelper(this);

        /// Setting the toolbar
        mToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Send a bug report/update suggestion");

        ///

        countrySelectSpinner = (Spinner) findViewById(R.id.spinner_country);
        selectCountryTv = (TextView) findViewById(R.id.tvSelectCountry);
        sendReportBtn = (Button) findViewById(R.id.sendFinal_btn);
        updateReportBtn = (Button) findViewById(R.id.updateRecord_btn);
        deleteReportBtn = (Button) findViewById(R.id.deleteRecord_btn);
        loadDataForEditBtn = (Button) findViewById(R.id.load_data_for_edit_btn);
        email_et = (EditText) findViewById(R.id.editText2);
        password_et = (EditText) findViewById(R.id.editText3);
        idForUpdate_et = (EditText) findViewById(R.id.et_id_update);
        problem_details_et = (EditText) findViewById(R.id.problem_details_et);

        /// Adapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySelectSpinner.setAdapter(adapter);
        countrySelectSpinner.setOnItemSelectedListener(this);


        // Using the obect passed from the previous activity

        receivedUser = new User();
        Intent i = getIntent();
        receivedUser = (User) i.getSerializableExtra("objectToPass");

        email_et.setText(receivedUser.getEmail());
        password_et.setText(receivedUser.getPassword());



        sendReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedbackForm.this, HelpActivity.class);
                ///
                selectedCountry = countrySelectSpinner.getSelectedItem().toString();

                boolean wasInserted = bugReportsDb.insertData(email_et.getText().toString().trim(),
                       selectedCountry, problem_details_et.getText().toString().trim());
                if(wasInserted == true)
                    Toast.makeText(FeedbackForm.this, "Added to DB", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(FeedbackForm.this, "FAILED!!!", Toast.LENGTH_LONG).show();




                intent.putExtra("selectedCountry", selectedCountry); //We pass a primitive data type to another activity
                startActivity(intent);
            }
        });

        // For updating a record based on ID

        updateReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedbackForm.this, HelpActivity.class);
                ///
                selectedCountry = countrySelectSpinner.getSelectedItem().toString();

                if(TextUtils.isEmpty(idForUpdate_et.getText().toString()))
                {
                    Toast.makeText(FeedbackForm.this,"YOU CANNOT UPDATE A BUG REPORT WITHOUT PROVIDING AN ID!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean wasUpdated = bugReportsDb.updateTheData(idForUpdate_et.getText().toString(),
                            email_et.getText().toString().trim(),
                            selectedCountry, problem_details_et.getText().toString().trim());
                    if(wasUpdated == true)
                        Toast.makeText(FeedbackForm.this, "DB was updated!", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(FeedbackForm.this, "DB update failed!", Toast.LENGTH_LONG).show();


                    intent.putExtra("selectedCountry", selectedCountry);
                    startActivity(intent);
                }
            }
        });

        // For deleting a record based on ID
        deleteReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedbackForm.this, HelpActivity.class);
                ///
                selectedCountry = countrySelectSpinner.getSelectedItem().toString();

                if(TextUtils.isEmpty(idForUpdate_et.getText().toString()))
                {
                    Toast.makeText(FeedbackForm.this,"YOU CANNOT DELETE A BUG REPORT WITHOUT PROVIDING AN ID!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Integer deletedDatabaseRow = bugReportsDb.deleteData(idForUpdate_et.getText().toString().trim());

                    if(deletedDatabaseRow > 0)
                        Toast.makeText(FeedbackForm.this, "Bug report/record was deleted from DB!", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(FeedbackForm.this, "Error: ID doesn not exist. Nothing was deleted from DB!", Toast.LENGTH_LONG).show();


                    intent.putExtra("selectedCountry", selectedCountry);
                    startActivity(intent);
                }

            }
        });

        // For loading a record based on ID in order to edit it
        loadDataForEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(idForUpdate_et.getText().toString()))
                {
                    Toast.makeText(FeedbackForm.this,"PROVIDE AN ID TO LOAD DATA FOR EDITING!", Toast.LENGTH_LONG).show();
                }
                else
                {
                        Cursor result = bugReportsDb.getDataById(Integer.parseInt(idForUpdate_et.getText().toString()));
                        if (result.getCount() == 0) {
                           Toast.makeText(FeedbackForm.this, "No data at that ID", Toast.LENGTH_LONG).show();
                        } else {
                            while (result.moveToNext()) {
                                email_et.setText(result.getString(1));
                                password_et.setText(result.getString(2));
                                problem_details_et.setText(result.getString(3));
                            }
                        }


                }
            }
        });
    }



    ///Override methods for the spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
