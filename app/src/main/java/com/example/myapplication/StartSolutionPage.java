package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StartSolutionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String ass_id = intent.getStringExtra("ass_id");
        String ass_name = intent.getStringExtra("ass_name");
        String status = intent.getStringExtra("status");
        setContentView(R.layout.activity_start_solution_page);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("This is the " + status + " of assignment id " + ass_id + " with assignment name " + ass_name);

    }
}