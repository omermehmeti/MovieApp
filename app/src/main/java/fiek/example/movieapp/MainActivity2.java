package fiek.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
   // TextView tvemail;
    ListView lvusers;
    UserAdapter useradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // String email = getIntent().getExtras().getString("email");

       // tvemail=findViewById(R.id.tvemail);

        //tvemail.setText(email);

        lvusers=findViewById(R.id.users);

        useradapter = new UserAdapter(MainActivity2.this);
        lvusers.setAdapter(useradapter);
       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        lvusers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this,"Uklikua pozicioni"+position,Toast.LENGTH_SHORT).show();
            }
        });
        GetData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.item1){
            Toast.makeText(MainActivity2.this,"U klikua nje item i menuse",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void GetData()
    {
        SQLiteDatabase objDb = new DatabaseHelper(MainActivity2.this).getReadableDatabase();

        Cursor cursor = objDb.query(DatabaseModelsHelper.userTable,
                new String[]{"Id",DatabaseModelsHelper.userName,DatabaseModelsHelper.userLastName,DatabaseModelsHelper.userEmail,DatabaseModelsHelper.userPassword},"",null,"","","");
            cursor.moveToFirst();
            while(cursor.isAfterLast()==false)
            {
                useradapter.dataSource.add(new UserModel(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4)));
                cursor.moveToNext();
            }
            cursor.close();
            objDb.close();
            useradapter.notifyDataSetChanged();


    }
}