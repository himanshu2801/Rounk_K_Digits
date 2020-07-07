package com.example.rounk_k_digits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class output extends AppCompatActivity {
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        output=(TextView) findViewById(R.id.inputdata);
        output.setText(getIntent().getStringExtra("data"));

    }
}
