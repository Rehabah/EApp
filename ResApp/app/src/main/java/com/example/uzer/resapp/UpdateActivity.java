package com.example.uzer.resapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View; //This class represents the basic building block for user interface components.
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends ActionBarActivity {


    //Update user information
    MyDB1 myDB2;
    EditText mobnumber, phon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDB2 =new MyDB1(this);
        mobnumber=(EditText) findViewById(R.id.mobnumberValue);//old relativemobile number
        phon =(EditText) findViewById(R.id.phonValue);//relatives phone number

    }
    public void update_phone(View v)
    {
        String mobile=mobnumber.getText().toString();
        String phone=phon.getText().toString();
        int x =myDB2. update_contact(mobile,phone);
        if (x>0)
        { Message.message(this,"تم تحديث الرقم");}
        else
        { Message.message(this,"لم يتم التحديث");}

    }
    //View user function

    MyDB1 myDB1 ;
    public  void view_user_data(View view)
    {
        String data= myDB1. get_data() ;
        Message.message(this,data);
    }

    //View contacts function
    public  void view_contacts_data(View view)
    {
        String data= myDB1. Relative_get_data();
        Message.message(this,data);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
