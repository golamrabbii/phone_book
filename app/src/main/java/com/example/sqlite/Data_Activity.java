package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Data_Activity extends AppCompatActivity {


    private TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_);


        txtview = findViewById(R.id.text_view);

        List<Info> infos = MainActivity.appDatabase.dao().getInfo();

        String info = "";

        for(Info in : infos)
        {
            String name = in.getName();
            String phone = in.getPhone();

            info = info+"\n\n"+"Name: "+name+"\n"+"Phone: "+phone;
        }

        txtview.setText(String.valueOf(info));

    }
}
