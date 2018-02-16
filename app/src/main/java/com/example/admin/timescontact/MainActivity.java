package com.example.admin.timescontact;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.tvc);
        getContactDetails();
    }

    private void getContactDetails() {
        StringBuffer sb=new StringBuffer();
        Cursor managedCursor=managedQuery(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        int num=managedCursor.getColumnIndex(ContactsContract.Contacts._ID);
        int name=managedCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        int timecon=managedCursor.getColumnIndex(ContactsContract.Contacts.TIMES_CONTACTED);


        sb.append("\n\n\n\n\nContact Details:");

        while(managedCursor.moveToNext())
        {
            String id=managedCursor.getString(num);
            String contactname=managedCursor.getString(name);
            String times=managedCursor.getString(timecon);
            Log.i("Data:",id+" | "+contactname+" | "+times);
            sb.append("\nID:"+id+"\nContact Name:"+contactname+"\nTimes Contacted:"+times);
            sb.append("\n-------------------------------------");
        }
        tv.setText(sb);
    }
}

