package com.example.thanhnguyen.simpleemail.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thanhnguyen.simpleemail.Models.GMailModel;
import com.example.thanhnguyen.simpleemail.R;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

public class MainActivity extends AppCompatActivity {

    GoogleAccountCredential mCredential;
    private TextView mOutputText;
    private Button mCallApiButton;
    private Button composeEmailButton;
    ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUI();
        addEvents();
        mCredential = GMailModel.GACred(getApplicationContext());
    }

    private void addUI() {
        mOutputText = (TextView) findViewById(R.id.mOutputText);
        mCallApiButton = (Button) findViewById(R.id.mCallApiButton);
        composeEmailButton = (Button) findViewById(R.id.composeEmailButton);
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Calling Gmail API ...");
    }

    private void addEvents() {
        mCallApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallApiButton.setEnabled(false);
                mOutputText.setText("");
                mCallApiButton.setEnabled(true);
                Intent intent = new Intent(MainActivity.this, GetEmailActivity.class);
                startActivity(intent);
            }
        });

        composeEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ComposeActivity.class);
                startActivity(intent);
            }
        });
    }

}
