package com.example.lab5mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    TextView name_txt,marks_txt;
    Button insert_btn,display_btn;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        insert_btn=(Button)findViewById(R.id.button);
        display_btn=(Button)findViewById(R.id.button2);
        View.OnClickListener onClickListener = ;
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button)
                {
                    myDB.insert_record(et1.getText().toString(),Integer.parseInt(et2.getText().toString()));
                    public void insert_record(String name,int marks)
                    {
                        String query="INSERT INTO student_table(Name,Marks)VALUES("+name+","+marks+");";
                        String query="INSERT INTO student_table VALUES(null,"+name+","+marks+");";
                        db.execSQL(query);
                        
                    }
                }
            }
        });
    }
}
