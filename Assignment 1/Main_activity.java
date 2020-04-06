package com.example.contentmad;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display_txt;
    ImageView iv;
    LinearLayout linearLayout,linearLayout1;
    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
            ,ContactsContract.Contacts.HAS_PHONE_NUMBER};
    private String mSelectionCluse = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " = ?";
    private String[] mSelectionArguments = new String[]{"Papa"};
    private String mOrderBy = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + "DESC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void loadContactNames(View v) {
        linearLayout=(LinearLayout)findViewById(R.id.ol);
        ContentResolver contentResolver = getContentResolver();
        Cursor cur = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null);
        assert cur != null;
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Log.i("Names", name);

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id,null, null);
                    assert phones != null;
                    while (phones.moveToNext()) {
                        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String photo = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                        Log.i("Number", phoneNumber+photo);
                        if (photo!=null)
                        {
                            Uri imgUri=Uri.parse(photo);
                            final ImageView imageView= new ImageView(this);
                            final TextView textView=new TextView(this);
                            textView.setText(name+" "+phoneNumber);
                            imageView.setImageURI(null);
                            imageView.setImageURI(imgUri);
                            linearLayout.addView(textView);
                            linearLayout.addView(imageView);
                        }
                    }
                    phones.close();
                }

            }
            cur.close();
        }
        else
        {
            display_txt.setText("No Contacts in device");
        }

    }


}
