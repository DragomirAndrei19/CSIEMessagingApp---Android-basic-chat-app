package com.example.csiemessagingappv1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HelpActivity extends AppCompatActivity {

    Button showSupportCentersBTN;
    Button showSentReportsBtn;
    Button updateReportBtn;
    Button deleteReportsBtn;
    Button showSentReportsByCountryBtn;
    Button exportReportAsTxtBtn;
    public TextView confirmationMessage;
    public static TextView data;
    public TextView currentLocation;
    public String receivedLocation;

    /// Sqlite database

    DatabaseHelper bugReportsDb;
    ///
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        /// SQLite database

        bugReportsDb = new DatabaseHelper(this);
        ////


        showSupportCentersBTN = (Button) findViewById(R.id.show_support_btn);
        showSentReportsBtn = (Button) findViewById(R.id.show_sent_reports);
        showSentReportsByCountryBtn = (Button) findViewById(R.id.show_report2_btn);
        updateReportBtn = (Button) findViewById(R.id.update_report_btn);
        deleteReportsBtn = (Button) findViewById(R.id.delete_reports_btn);
        exportReportAsTxtBtn = (Button) findViewById(R.id.export_reportToTxt_Btn);
        confirmationMessage = (TextView) findViewById(R.id.confirmation_message);
        currentLocation = (TextView) findViewById(R.id.confirmation_message);

        receivedLocation = getIntent().getStringExtra("selectedCountry");
        currentLocation.setText("Current location: " + receivedLocation);


        //confirmationMessage.setText("Report sent!");
        data = (TextView) findViewById(R.id.fetchjsondata);

        showSupportCentersBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJsonData process = new fetchJsonData();
                process.execute();
            }
        });

        showSentReportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor theResult = bugReportsDb.getAllData();
                if (theResult.getCount() == 0)
                {
                    showTheMessage("Error", "Nothing found in the database!");

                    return;
                }

                else {
                    StringBuffer buffer = new StringBuffer();
                    while(theResult.moveToNext()) {
                        buffer.append("ID: " + theResult.getString(0)+"\n");
                        buffer.append("Email: " + theResult.getString(1)+"\n");
                        buffer.append("Country: " + theResult.getString(2)+"\n");
                        buffer.append("Problem: " + theResult.getString(3)+"\n");



                    }
                    showTheMessage("History of bug reports: ", buffer.toString());
                }

            }


        });

        updateReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, FeedbackForm.class);
                startActivity(intent);
            }
        });

        deleteReportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, FeedbackForm.class);
                startActivity(intent);
            }
        });

        showSentReportsByCountryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor theResult = bugReportsDb.getCustomData(receivedLocation);
                if (theResult.getCount() == 0)
                {
                    showTheMessage("Error", "Nothing found in the database!");

                    return;
                }

                else {
                    StringBuffer buffer = new StringBuffer();
                    while(theResult.moveToNext()) {
                        buffer.append("ID: " + theResult.getString(0)+"\n");
                        buffer.append("Country: " + theResult.getString(2)+"\n");
                        buffer.append("Email: " + theResult.getString(1)+"\n");
                        //buffer.append("Problem: " + theResult.getString(3)+"\n");



                    }
                    showTheMessage("History of bug reports from " + receivedLocation + ": ", buffer.toString());
                }
            }
        });


        // Exporting the report as a .txt file (permissions were granted in the manifest file)

        exportReportAsTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor theResult = bugReportsDb.getAllData();
                if (theResult.getCount() == 0) {
                    Toast.makeText(HelpActivity.this, "No data EXPORTED!", Toast.LENGTH_LONG).show();
                    //return;
                } else {
                    StringBuilder buffer = new StringBuilder();
                    while(theResult.moveToNext()) {
                        buffer.append("ID: " + theResult.getString(0) + "\n");
                        buffer.append("Email: " + theResult.getString(1) + "\n");
                        buffer.append("Country: " + theResult.getString(2) + "\n");
                        buffer.append("Problem: " + theResult.getString(3) + "\n");
                    }

                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput("BugReportHistory", MODE_PRIVATE);
                        fos.write(buffer.toString().getBytes());
                        Toast.makeText(HelpActivity.this, "Data exported as TXT", Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (fos != null){
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    // Method for creating a visual report ( as an alert )

    public void showTheMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
