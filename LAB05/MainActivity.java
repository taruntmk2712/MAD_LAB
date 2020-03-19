package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper myDB;
    Button insert_btn,display_btn,delete_btn,update_btn;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        insert_btn = (Button) findViewById(R.id.button);
        display_btn = (Button) findViewById(R.id.button2);
        delete_btn = (Button) findViewById(R.id.button3);
        update_btn = (Button) findViewById(R.id.button4);
        insert_btn.setOnClickListener(this);
        display_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        update_btn.setOnClickListener(this);
    }
    public void showMessage(String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }

    public void onClick(View v) {
        if(v.getId()==R.id.button)
        {
            if (et1.getText().toString().trim().length() == 0 ||et2.getText().toString().trim().length() == 0)
            {
                showMessage("Error,Please enter all values!");
                return;
            }
            myDB.insert_record(et1.getText().toString(),Integer.parseInt(et2.getText().toString()));
            showMessage("Success, Record Inserted!");
            clearText();
        }
        if(v.getId()==R.id.button2){
            StringBuffer record_details=myDB.display_all_records();
            showMessage(record_details.toString());
        }
        if(v.getId()==R.id.button3)
        {
            if(et1.getText().toString().trim().length() == 0)
            {
                showMessage("Error, Please enter name!");
                return;
            }
            myDB.delete_record(et1.getText().toString());
            showMessage("Success,Record Deleted!");
            clearText();
        }
        if(v.getId()==R.id.button4)
        {
            if(et1.getText().toString().trim().length()==0||et2.getText().toString().trim().length() == 0)
            {
                showMessage("Error, Please enter data!");
                return;
            }
            myDB.update_record(et1.getText().toString(),Integer.parseInt(et2.getText().toString()));
            showMessage("Success,Record Updated!");
            clearText();
        }
    }
    public void clearText()
    {
        et1.setText("");
        et2.setText("");
    }
}
