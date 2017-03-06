package com.example.thanhnguyen.simpleemail.Activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.thanhnguyen.simpleemail.Models.GMailModel;
import com.example.thanhnguyen.simpleemail.R;

public class ComposeActivity extends AppCompatActivity {

    FloatingActionButton sendEmailButton;
    EditText txtToEmail, txtSubject, txtBody;
    GMailModel gMailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        addUI();
        init();
        addEvents();
    }

    private void addUI() {

        txtToEmail = (EditText) findViewById(R.id.txtToEmail);
        txtSubject = (EditText) findViewById(R.id.txtSubject);
        txtBody = (EditText) findViewById(R.id.txtBody);
        sendEmailButton = (FloatingActionButton) findViewById(R.id.sendEmail);
    }

    private void addEvents() {
        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gMailModel.getResultsFromApi(view);
            }
        });
    }

    private void init() {
        // Initialize gmail service object.
        gMailModel = new GMailModel(getApplicationContext(), getWindow().getDecorView(), ComposeActivity.this);
    }



}
