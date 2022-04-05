package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginForm extends AppCompatActivity {
    Boolean EditTextEmptyHolder;
    EditText Username, Password;
    String UsernameHolder, PasswordHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper myDB;
    Cursor cursor;
    String TempPassword = "NOT_FOUND";
    public static final String UserName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        TextView signup = (TextView) findViewById(R.id.createnewac);
        TextView registerbtn = (TextView) findViewById(R.id.register);

        Button loginbtn = (Button) findViewById(R.id.loginbutton);

        myDB = new SQLiteHelper(this);
    }
}


//        loginbtn.setBackgroundColor(Color.BLACK);
//
//
//            loginbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    // Calling EditText is empty or no method.
//                    CheckEditTextStatus();
//
//                    // Calling login method.
//                    LoginFunction();
//
//
//                }
//            });

//                if (cursor.getCount() == 0) {
//                    Toast.makeText(LoginForm.this, "No entries Exists", Toast.LENGTH_LONG).show();
//                }
//
//                if (loginCheck(cursor, uName, pWord)) {
//                    Intent intent = new Intent(LoginForm.this, Login.class);
//                                       username.setText("");
//                    password.setText("");
//                    startActivity(intent);
//                } else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginForm.this);
//                    builder.setCancelable(true);
//                    builder.setTitle("Wrong Credential");
//                    builder.setMessage("Wrong Credential");
//                    builder.show();
//                }
//                myDB.close();
//            }
//        });

//        registerbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginForm.this, SignUpActivity.class));
//            }
//        });
//    }



//    @SuppressLint("Range")
//    public void LoginFunction(){
//
//        if(EditTextEmptyHolder) {
//
//            // Opening SQLite database write permission.
//            sqLiteDatabaseObj = myDB.getWritableDatabase();
//
//            // Adding search email query to cursor.
//            cursor = sqLiteDatabaseObj.query(SQLiteHelper.Table_NAME, null, " " + SQLiteHelper.COL_2 + "=?", new String[]{UsernameHolder}, null, null, null);
//
//            while (cursor.moveToNext()) {
//
//                if (cursor.isFirst()) {
//
//                    cursor.moveToFirst();
//
//                    // Storing Password associated with entered email.
//                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COL_4));
//
//                    // Closing cursor.
//                    cursor.close();
//                }
//            }
//
//            // Calling method to check final result ..
//            CheckFinalResult();
//
//        }
//        else {
//
//            //If any of login EditText empty then this block will be executed.
//            Toast.makeText(LoginForm.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();
//
//        }
//
//    }
//
//    // Checking EditText is empty or not.
////    public void CheckEditTextStatus(){
////
////        // Getting value from All EditText and storing into String Variables.
////        UsernameHolder = Username.getText().toString();
////        PasswordHolder = Password.getText().toString();
////
////        // Checking EditText is empty or no using TextUtils.
////        if( TextUtils.isEmpty(UsernameHolder) || TextUtils.isEmpty(PasswordHolder)){
////
////            EditTextEmptyHolder = false ;
////
////        }
////        else {
////
////            EditTextEmptyHolder = true ;
////        }
////    }
////
////    // Checking entered password from SQLite database email associated password.
////    public void CheckFinalResult(){
////
////        if(TempPassword.equalsIgnoreCase(PasswordHolder))
////        {
////
////            Toast.makeText(LoginForm.this,"Login Successful",Toast.LENGTH_LONG).show();
////
////            // Going to Dashboard activity after login success message.
////            Intent intent = new Intent(LoginForm.this, Login.class);
////
////            // Sending Email to Dashboard Activity using intent.
////            intent.putExtra(UserName, UsernameHolder);
////
////            startActivity(intent);
////
////
////        }
////        else {
////
////            Toast.makeText(LoginForm.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
////
////        }
////        TempPassword = "NOT_FOUND" ;
////
////    }
////
////}
//


