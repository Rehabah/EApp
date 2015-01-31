package com.example.uzer.resapp;

import android.content.ContentValues;//This class is used to store a set of values
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;// class to open database if exist or create it if not exist
import com.example.uzer.resapp.MainActivity;
import com.example.uzer.resapp.UserInfoActivity;


public class MyDB1 extends SQLiteOpenHelper { //subclass of sqlitehelper
    MyDB1 myDB2; //object of MyDB1 class
    //constant variables
    private static final String DB_NAME ="EmerDB1";   //Database name
    private static final int DATABASE_VERSION =1;
    private static final String TABLE1_NAME="User1";   //Name of table one
    private static final String TABLE2_NAME="Contacts"; //Name of table two
    private static final String TABLE3_NAME="Chronic_diseases1";  //Name of table three
    private static final String TABLE4_NAME="Emergency_Agencies";   //Name of table four
    private static final String TABLE5_NAME="Emergency_situation";  //Name of table five
    private static final String Mobile_number="Mobile_number"; //column name in user table
    private static final String First_Name="First_Name";  //column name in user table
    private static final String Last_Name ="Last_Name";    //column name in user table
    private static final String Birth_date="Birth_date";   //column name in user table
    private static final String Gender="Gender";    //column name in user table
    private static final String Longitude_value="Longitude_value";  //column name in user table
    private static final String Latitude_value="Latitude_value";    //column name in user table
    private static final String Phone_number="Phone_number ";    //column name in Contacts Table
    private static final String Chronic_diseases="Chronic_diseases";  //column name in Chronic_diseases Table
    private static final String Emergency_telephone_number="Emergency_telephone_number"; //column name in Emergency agency Table
    private static final String  Emergency_agency_name="Emergency _agency_name";    //column name in Emergency agency Table
    private static final String ID="ID";  //column name in Emergency Situation Table
    private static final String Type="Type";  //column name in Emergency Situation Table
    private static final String First_aid_treatment_instruction="First_aid_treatment_instruction";  //column name in Emergency Situation Table

    private Context context;//to use to open or create the database

    public MyDB1(Context context)  //constructor
    { super (context , DB_NAME, null, DATABASE_VERSION); //super class constructor
        this.context=context;
    }

    @Override  //to create database tables
    public void onCreate(SQLiteDatabase db) {
        //create table user1
        db.execSQL("Create table "+TABLE1_NAME+"("+ Mobile_number +"Char(10) Primary key"+ First_Name +" Varchar(20)" +
                Last_Name +" Varchar(20)"+Birth_date +"Varchar(10)"+ Gender+"Char(6)"+Longitude_value +"integer null"+
                Latitude_value+"integer null"+Emergency_telephone_number +"VarChar(4)"+ ID +"Char(2)" +
                "Foreign Key ("+ Emergency_telephone_number+") REFERENCES"+ TABLE4_NAME +"("+Emergency_telephone_number+")" +
                "Foreign Key(" +ID+") REFERENCES"+TABLE5_NAME +"("+ID+"));");

        // create table contacts
        db.execSQL("Create Table"+TABLE2_NAME+"("+Phone_number +"Char(10)"+
                Mobile_number+" Char(10) Primary key("+Phone_number+")"+"("+Mobile_number+")" +"Foreign Key ("+ Mobile_number+")REFERENCES" +TABLE1_NAME+"("+Mobile_number+"));");

        //create table chronic diseases
        db.execSQL( "Create Table"+TABLE3_NAME+"("+Chronic_diseases+" Varchar(50)"+Mobile_number +"Char(10) " +
                " Primary key+("+Chronic_diseases+")"+"("+Mobile_number +")"+"Foreign Key ("+Mobile_number+") REFERENCES"+
                TABLE1_NAME +"("+Mobile_number+"));");

        //create table Emergency Agency
        db.execSQL("Create Table"+TABLE4_NAME+"("+Emergency_telephone_number+" VarChar(4) Primary Key"+ Emergency_agency_name+" Varchar(40)");

        //Insert data in table Emergency Agency

        db.execSQL( "insert into"+ TABLE4_NAME+" values ('112', 'KSA Emergency' );" );
        db.execSQL( "insert into"+ TABLE4_NAME+" values ('998', 'Civil Defense' );" );
        db.execSQL( "insert into"+ TABLE4_NAME+" values ('997', 'Ambulance' );" );
        db.execSQL( "insert into"+ TABLE4_NAME+" values ('999', 'Police' );" );
        db.execSQL( "insert into"+ TABLE4_NAME+"values ('993', 'Traffic Police' );" );
        db.execSQL( "insert into"+ TABLE4_NAME+" values ('112', 'Road Security' );" );

        //create table Emergency Situations
        db.execSQL("Create Table"+TABLE5_NAME+"("+ID+" Char(2) Primary Key"+Type+" Varchar(40)"+First_aid_treatment_instruction+" Char(3)" +
                Emergency_telephone_number+" VarChar(4)"+"Foreign Key ("+Emergency_telephone_number+") REFERENCES"+ TABLE4_NAME+"("+Emergency_telephone_number+"));");

        //Insert data in table Emergency Situations

        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (1,'Fire', 'A1','998' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (2,'Sinking', 'A2','998' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (3,'Suffocation', 'A3','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (4,'Bleeding', 'A4','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (5,'Wound', 'A5','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (6,'Angina', 'A6','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (7,'Heart Attack', 'A7','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (8,'Fracture', 'A8','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (9,'Car Accident', 'A9','999' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (10,'Poisoning', 'A10','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (11,'Coma', 'A11','997' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (12,'Disaster', 'A12','998' );" );
        db.execSQL( "insert into"+ TABLE5_NAME+"(ID,Type, First_aid_treatment_instruction,Emergency_telephone_number) values (13,'Nothing', 'A13','112' );" );

    }

    @Override
    //to modify tables by adding new columns or drop tables
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table user
        db.execSQL("Drop Table if exist User");
        //calling oncreate method to create table again
        onCreate(db);
    }

    //insert data to user table
    public long insert_user_data( String mnumber,String fname, String lname, String date,String sex){
        String x="1";   //default value of ID column in Emergency Situations Table
        String y= "122";  //default value of Emergency telephone column in Emergency Agency Table

        SQLiteDatabase db=myDB2.getWritableDatabase();//to access database
        ContentValues contentValues=new ContentValues();  //Creates an empty set of values using the default initial size

        //get data from user and store them in user1 table columns
        contentValues.put(Mobile_number,mnumber);
        contentValues.put(First_Name,fname);
        contentValues.put(Last_Name,lname);
        contentValues.put(Birth_date,date);
        contentValues.put(Gender,sex);
        contentValues.put( Emergency_telephone_number,y);
        contentValues.put(ID,x);

        //inserting data into the table
        long id1=db.insert(TABLE1_NAME,null,contentValues);
        return id1;}

    //inserting diseases
    public long insert_chronic_disease(String disease,String mnumber)
    {
        SQLiteDatabase  db=myDB2.getWritableDatabase();
        ContentValues contentValues1=new ContentValues();//Creates an empty set of values using the default initial size

        //get data from user and store them in user1 table columns
        contentValues1.put( Chronic_diseases ,disease);
        contentValues1.put(Mobile_number,mnumber);
        //inserting data into the table
        long id2 =db.insert(TABLE3_NAME,null,contentValues1);
        return id2;

    }

    //inserting relatives data
    public long insert_relatives_data (String mobile,String mnumber ,String mnumber1)
    {
        SQLiteDatabase  db=myDB2.getWritableDatabase();
        ContentValues contentValues2=new ContentValues();

        //get data from user and store them in user1 table columns
        contentValues2.put(Mobile_number,mobile);
        contentValues2.put(Phone_number,mnumber);
        contentValues2.put(Mobile_number,mobile);
        contentValues2.put(Phone_number,mnumber1);

        //how many rows
        //inserting data into the table
        long id3 =db.insert(TABLE2_NAME,null,contentValues2);
        return id3;


    }
    //to view user's information
    public String get_data()
    {
        SQLiteDatabase db=myDB2.getWritableDatabase();
        String[] columns={Mobile_number,First_Name,Last_Name,Birth_date};//specifying columns that we need to present the data to user
        Cursor cursor=db.query(TABLE1_NAME, columns, null, null, null, null, null);//selection arguments group by , having ,order having null value
        //cursor to retrieve subset from user table which contain result before first true
        StringBuffer buffer=new StringBuffer(25);//to append data

        while(cursor.moveToNext()) //to navigate between rows
        {
            //depending on the position of columns in database
            String mobile=cursor.getString(0);
            String fname=cursor.getString(1);
            String lname=cursor.getString(2);
            String bdate=cursor.getString(3);
            buffer.append(mobile+""+fname+""+lname+""+bdate+"\n");

        }
        return buffer.toString();
    }

    //to view user's information
    public String Relative_get_data()
    {
        SQLiteDatabase db=myDB2.getWritableDatabase();
        String[] columns={Phone_number};
        Cursor cursor1=db.query(TABLE2_NAME, columns, null, null, null, null, null);//selection arguments group by , having ,order having null value
        //cursor to retrieve subset from user table which contain result before first true
        StringBuffer buffer1=new StringBuffer();//to append data

        while(cursor1.moveToNext()) //to navigate between rows
        {
            //depending on the position of columns in database

            String phone=cursor1.getString(0);
            String relation=cursor1.getString(1);
            buffer1.append(phone+""+relation+"\n");

        }
        return buffer1.toString();
    }

    //update contacts numbers

    public int update_contact(String phone ,String mobile)
    {
        SQLiteDatabase db=myDB2.getWritableDatabase();
        ContentValues contentValues2=new ContentValues();
        contentValues2.put(Phone_number,mobile);
        String[] c={phone};//old value
        int x=db.update(TABLE2_NAME,contentValues2,Phone_number+"=?",c);
        return x;
    }


    //update GPS
}
