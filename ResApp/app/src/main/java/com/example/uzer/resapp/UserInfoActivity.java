package com.example.uzer.resapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase; //importing database
import android.view.View;//This class represents the basic building block for user interface components.
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class UserInfoActivity extends ActionBarActivity {

    EditText first_name,last_name,birth_day,mobnumber,numrelatives1,numrelatives2;
    private RadioGroup radioGroup; //radio group
    private RadioButton radioSexButton; // radio button
    MyDB1 myDB1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_name=(EditText) findViewById(R.id.first_nameValue);
        last_name=(EditText) findViewById(R.id.last_nameValue);
        mobnumber=(EditText) findViewById(R.id. mobnumberValue);//user's mobile number
        birth_day=(EditText) findViewById(R.id.birth_dayValue);
        numrelatives1=(EditText) findViewById(R.id.numrelativesValue);//relatives phone number
        numrelatives2=(EditText) findViewById(R.id.numrelativesValue2);
        radioGroup = (RadioGroup) findViewById(R.id.radioSex);
        myDB1=new MyDB1(this);
    }

    public void save(View view)
    {
        String mobile=mobnumber.getText().toString();
        String name1=first_name.getText().toString();
        String name2=last_name.getText().toString();
        String birth=birth_day.getText().toString();

        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if(selectedId != -1) {
            // find the radiobutton by returned id
            radioSexButton = (RadioButton) findViewById(selectedId);
            // do what you want with radioButtonText (save it to database in your case)
            String radioButtonText = radioSexButton.getText().toString();

            long id = myDB1.insert_user_data(mobile, name1, name2, birth, radioButtonText);
            //code checkbox of chronic diseases



            long id1=myDB1.insert_chronic_disease( disease, mobile);

            //insertion of contact table
            String relativenumber= numrelatives1.getText().toString();
            String relativenumber1= numrelatives2.getText().toString();
            long id2 = myDB1.insert_relatives_data ( mobile,relativenumber,relativenumber1);

            if(( id  <0) && (id1 <0) &&(id2 <0))
            { Message.message(this,"لم يتم إدخال بياناتك");}
            else
            {
                Message.message(this,"تم حفظ بياناتك");}
        }

        Intent intent = new Intent(this, MainActivity.class);//next activity
        startActivity(intent);

    }


            public void skip(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        Message.message(this,"ستنتقل إلى الصفحة التالية");
        startActivity(intent);
        //next activity
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
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

