package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;

import android.Manifest;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button write,read,clear;
    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.editText);
        write= (Button) findViewById(R.id.button);
        read= (Button) findViewById(R.id.button2);
        clear= (Button) findViewById(R.id.button3);


       // ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            write.setEnabled(false);
            read.setEnabled(false);
            clear.setEnabled(false);
        }else{
            myFile = new File(getExternalFilesDir(filepath), filename);
        }

        write.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg=e1.getText().toString();
                try{
                    /*File sdCard=
                            Environment.getExternalStorageDirectory();
                    File directory=new
                            File(sdCard.getAbsolutePath()+"/BMSCE");
                    boolean mkdirs = directory.mkdirs();
                    File myFile=new
                            File(directory,"ramu_pri.txt");*/
                    FileOutputStream fout= new
                            FileOutputStream(myFile);
                    fout.write(msg.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(),"Data written in sdcard", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),
                            e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                String buf="";
                try {
                    /*File sdCard =
                            Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath()
                            + "/BMSCE");
                    File myFile = new File(directory, "ramu_pri.txt");*/
                    FileInputStream fin=new FileInputStream(myFile);
                    DataInputStream in = new DataInputStream(fin);
                    BufferedReader br=new BufferedReader(new
                            InputStreamReader(fin));
                    while ((msg=br.readLine())!=null)
                    {
                        buf+=msg;
                    }
                    e1.setText(buf);
                    br.close();
                    fin.close();
                    Toast.makeText(getBaseContext(), " Data recived in sd card ", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });
    }
    private static boolean isExternalStorageReadOnly(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
