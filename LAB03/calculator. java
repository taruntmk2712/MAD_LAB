package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText n1=(EditText)findViewById(R.id.n1);
        final EditText n2=(EditText)findViewById(R.id.n2);
        Button btnAdd=(Button) findViewById(R.id.btnAdd);
        Button btnSub=(Button) findViewById(R.id.btnSub);
        Button btnMul=(Button) findViewById(R.id.btnMul);
        Button btnDiv=(Button) findViewById(R.id.btnDiv);
        final TextView res=(TextView)findViewById(R.id.res);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a=Float.parseFloat(n1.getText().toString());
                float b=Float.parseFloat(n2.getText().toString());
                float c=a+b;
                res.setText("Result = "+c);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a=Float.parseFloat(n1.getText().toString());
                float b=Float.parseFloat(n2.getText().toString());
                float c=a-b;
                res.setText("Result = "+c);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a=Float.parseFloat(n1.getText().toString());
                float b=Float.parseFloat(n2.getText().toString());
                float c=a*b;
                res.setText("Result = "+c);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a=Float.parseFloat(n1.getText().toString());
                float b=Float.parseFloat(n2.getText().toString());
                float c=a/b;
                res.setText("Result = "+c);
            }
        });
    }
}
