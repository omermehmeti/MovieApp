package fiek.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etLastName,etEmail,etPasword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName=findViewById(R.id.edtextname);
        etLastName=findViewById(R.id.edtextlastname);
        etEmail=findViewById(R.id.edtextemail);
        etPasword=findViewById(R.id.edtextpasword);

        btnSignUp=findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbObj = new DatabaseHelper(MainActivity.this).getWritableDatabase();

                ContentValues contentvalues  = new ContentValues();
                contentvalues.put(DatabaseModelsHelper.userName,etName.getText().toString());
                contentvalues.put(DatabaseModelsHelper.userLastName,etLastName.getText().toString());
                contentvalues.put(DatabaseModelsHelper.userEmail,etEmail.getText().toString());
                contentvalues.put(DatabaseModelsHelper.userPassword,etPasword.getText().toString());

                try
                {
                    long id =dbObj.insert(DatabaseModelsHelper.userTable,null,contentvalues);
                    if(id>0)
                    {
                        Toast.makeText(MainActivity.this,R.string.succes_db_Save,Toast.LENGTH_LONG).show();
                    }

                    Intent ActivityIntent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(ActivityIntent);

                }
                catch (Exception ex)
                {
                    Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
                finally
                {
                    dbObj.close();
                }
            }
        });


    }
}