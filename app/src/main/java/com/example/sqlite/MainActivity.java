package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;

    private EditText phone;

    private Button add;

    private Button view;

    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"infodb").allowMainThreadQueries().build();

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        add = (Button) findViewById(R.id.add_info);
        view = (Button) findViewById(R.id.view_info);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm = name.getText().toString();
                String phn = phone.getText().toString();

                Info info = new Info();
                info.setName(nm);
                info.setPhone(phn);
                info.setId(1);

                MainActivity.appDatabase.dao().insert(info);
                Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_SHORT).show();

                name.setText("");
                phone.setText("");

            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Data_Activity.class));

            }
        });

    }
}
