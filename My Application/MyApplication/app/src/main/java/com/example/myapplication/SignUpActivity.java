package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText Email, Password, Username ;
     Button signUpButton;
     SQLiteHelper myDB;

    public String NameHolder, EmailHolder, PasswordHolder;
    public Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;

    Cursor cursor;
    String F_Result = "Not_Found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Email = findViewById(R.id.email);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);

        signUpButton = findViewById(R.id.submitbutton);

        myDB = new SQLiteHelper(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();


            }
        });

    }

        // SQLite database build method.
        public void SQLiteDataBaseBuild(){

            sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

        }

        // SQLite table build method.
        public void SQLiteTableBuild() {

            sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.Table_NAME + "(" + SQLiteHelper.COL_1 + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper.COL_2 + " VARCHAR, " + SQLiteHelper.COL_3 + " VARCHAR, " + SQLiteHelper.COL_4 + " VARCHAR);");

        }

        // Insert data into SQLite database method.
        public void InsertDataIntoSQLiteDatabase(){

            // If editText is not empty then this block will executed.
            if(EditTextEmptyHolder == true)
            {

                // SQLite query to insert data into table.
                SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.Table_NAME+" (USERNAME,EMAIL,PASSWORD)VALUES('"+NameHolder+"', '"+EmailHolder+"', '"+PasswordHolder+"');";

                // Executing query.
                sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

                // Closing SQLite database object.
                sqLiteDatabaseObj.close();

                // Printing toast message after done inserting.
                Toast.makeText(SignUpActivity.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);

                // Sending Email to Dashboard Activity using intent.
                startActivity(intent);

            }
            // This block will execute if any of the registration EditText is empty.
            else {

                // Printing toast message if any of EditText is empty.
                Toast.makeText(SignUpActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

            }

        }

        // Empty edittext after done inserting process method.
        public void EmptyEditTextAfterDataInsert(){

            Username.getText().clear();

            Email.getText().clear();

            Password.getText().clear();

        }

        // Method to check EditText is empty or Not.
        public void CheckEditTextStatus(){

            // Getting value from All EditText and storing into String Variables.
            NameHolder = Username.getText().toString() ;
            EmailHolder = Email.getText().toString();
            PasswordHolder = Password.getText().toString();

            if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

                EditTextEmptyHolder = false ;

            }
            else {

                EditTextEmptyHolder = true ;
            }
        }

        // Checking Email is already exists or not.
        public void CheckingEmailAlreadyExistsOrNot(){

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = myDB.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.Table_NAME, null, " " + SQLiteHelper.COL_3 + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // If Email is already exists then Result variable value set as Email Found.
                    F_Result = "Email Found";

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result and insert data into SQLite database.
            CheckFinalResult();

        }


        // Checking result
        public void CheckFinalResult(){

            // Checking whether email is already exists or not.
            if(F_Result.equalsIgnoreCase("Email Found"))
            {

                // If email is exists then toast msg will display.
                Toast.makeText(SignUpActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();

            }
            else {

                // If email already dose n't exists then user registration details will entered to SQLite database.
                InsertDataIntoSQLiteDatabase();

            }

            F_Result = "Not_Found" ;

        }

    }





