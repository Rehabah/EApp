package com.example.uzer.resapp;

/**
 * Created by Uzer on 1/31/2015.
 */

import android.content.Context;
import android.widget.Toast;// quick little message for the user. The toast class helps you create and show those.

public class Message {
    public static void message(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
