package com.example.uzer.resapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.SharedPreferences;// for activity first Run..by Rawan



public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs = null;// for app first Run..by Rawan

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.example.rescueapp", MODE_PRIVATE);// for app first Run..by Rawan
    }

    @Override
    protected void onResume() {
        super.onResume();
        // for app first Run..by Rawan
        if (prefs.getBoolean("firstrun", true)) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
