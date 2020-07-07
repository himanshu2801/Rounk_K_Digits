package com.example.rounk_k_digits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText number;
    private EditText K;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        number=(EditText) findViewById(R.id.input);
        K=(EditText) findViewById(R.id.k_value);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data= removeKdigits(number.getText().toString() , Integer.parseInt(K.getText().toString()));
                Intent intent = new Intent(MainActivity.this,output.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }
    public String removeKdigits(String num, int k)
    {
        if (num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder(num);

        /*We will iterate the number k times. In each iteration:
        1. Remove the digit for which the next digit is smaller.
        2. If we reach at the end than remove last digit.*/
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}

