package fiek.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    Button LogInButton,SignUpButton;
    EditText etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInButton=findViewById(R.id.btnLogin);

        SignUpButton=findViewById(R.id.btnSignUp);

        etEmail=findViewById(R.id.edittextusername);

        etPassword=findViewById(R.id.edittextpassword);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LoginActivityIntent = new Intent(LogInActivity.this,MainActivity.class);
                startActivity(LoginActivityIntent);

            }
        });

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int  autenticate =Login(etEmail.getText().toString(),etPassword.getText().toString());

                if(autenticate==0)
                {
                    //Toast.makeText(LogInActivity.this,R.string.user_loggedin,Toast.LENGTH_LONG).show();
                    Intent MainActivityIntent = new Intent(LogInActivity.this,MainActivity2.class);
                    MainActivityIntent.putExtra("emaili",etEmail.getText().toString());
                    startActivity(MainActivityIntent);
                }
                else if (autenticate==1){
                    Toast.makeText(LogInActivity.this,R.string.user_wrong_credintials,Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(LogInActivity.this,R.string.user_not_found,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    protected  int  Login(String email,String password)
    {
        SQLiteDatabase dbObj = new DatabaseHelper(LogInActivity.this).getReadableDatabase();

        Cursor kursor = dbObj.query(DatabaseModelsHelper.userTable,new String[]{DatabaseModelsHelper.userEmail,DatabaseModelsHelper.userPassword},
                DatabaseModelsHelper.userEmail+"=?", new String[]{email},"","","");

        if(kursor.getCount()>0)
        {
            kursor.moveToFirst();
            String dbUserMail = kursor.getString(0);
            String dbUserPassword = kursor.getString(1);
            kursor.close();
            dbObj.close();

            if(password.equals(dbUserPassword)){
                return 0;
            }
            else {
                return 1;
            }



        }
        return -1;

    }
}