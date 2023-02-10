package com.example.sql1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,upass;
    Button register,delete,display,update;
    TextView res;
    DbHelper mydbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        upass=findViewById(R.id.upass);
        register=findViewById(R.id.register);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        display=findViewById(R.id.display);
        res=findViewById(R.id.res);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydbhelper=new DbHelper(MainActivity.this,"user",null,1);
                long val=mydbhelper.addUser(uname.getText().toString(),upass.getText().toString(
                ));
                if(val==-1)
                {
                    Toast.makeText(MainActivity.this, "Error in adding the user", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "User added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydbhelper=new DbHelper(MainActivity.this,"user",null,1);

                mydbhelper.update(uname.getText().toString(),upass.getText().toString());
                Toast.makeText(MainActivity.this, "User updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydbhelper=new DbHelper(MainActivity.this,"user",null,1);
                mydbhelper.deleteUser(uname.getText().toString());
                Toast.makeText(MainActivity.this, "User deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydbhelper=new DbHelper(MainActivity.this,"user",null,1);
                String result=mydbhelper.display(MainActivity.this);
                res.setText(result);
            }
        });

    }
}



package com.example.sql1;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String dbName="userDB"; // Database Name
    //private static final String tbName="user" ; // Table Name
    private static final int dbVersion = 1 ;
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, null, dbVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(uname varchar(10),upass varchar(10));");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user;");
        onCreate(db);
    }
    public long addUser(String uname,String upass)
    {
        SQLiteDatabase myDb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("uname",uname);
        cv.put("upass",upass);
        long val=myDb.insert("user",null,cv);
        myDb.close();
        return val;
    }
    public void deleteUser(String uname)
    {
        SQLiteDatabase myDb=this.getWritableDatabase();
        myDb.execSQL("delete from user where uname='"+uname+"';");
        myDb.close();
    }
    public void update(String uname,String upass)
    {
        SQLiteDatabase myDb=this.getWritableDatabase();
        myDb.execSQL("update user set upass='"+upass+"'"+" where uname='"+uname+"';");
        myDb.close();
    }
    public String display(Context ctx)
    {
        SQLiteDatabase myDb=this.getReadableDatabase();
        String finalRes="";
        Cursor cursor=myDb.rawQuery("select * from user",null);
        while(cursor.moveToNext())
        {
            finalRes+= cursor.getString(0)+":"+cursor.getString(1)+"\n";
        }
        return finalRes;
    }

}
