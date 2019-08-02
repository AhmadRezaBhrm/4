package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    TextView name;
    TextView family;
    TextView mail;
    TextView phone;
    Button btnS;
    Button btnE;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        name = findViewById(R.id.name);
        family = findViewById(R.id.family);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        btnS = findViewById(R.id.save);
        btnE = findViewById(R.id.edit);
        Intent intent = getIntent();

        String flag = intent.getStringExtra("flag");

        if (flag.equals("1")) {


            name.setText(PreferenceManager.getDefaultSharedPreferences(Information.this)
                    .getString("name", "null"));
            family.setText(PreferenceManager.getDefaultSharedPreferences(Information.this)
                    .getString("family", "null"));
            mail.setText(PreferenceManager.getDefaultSharedPreferences(Information.this)
                    .getString("mail", "null"));
            phone.setText(PreferenceManager.getDefaultSharedPreferences(Information.this)
                    .getString("phone", "null"));
        }
        if (flag.equals("0")) {

            name.setText("name:" + intent.getStringExtra("name"));
            family.setText("family:" + intent.getStringExtra("family"));
            mail.setText("mail:" + intent.getStringExtra("mail"));
            phone.setText("phone:" + intent.getStringExtra("phone"));

            btnS.setOnClickListener((v)->{
                PreferenceManager.getDefaultSharedPreferences(Information.this).edit()
                        .putString("name",intent.getStringExtra("name"))
                        .putString("family",intent.getStringExtra("family"))
                        .putString("mail",intent.getStringExtra("mail"))
                        .putString("phone",intent.getStringExtra("phone")).apply();
                Intent intent1 = new Intent();
                setResult(Activity.RESULT_OK,intent1);
                finish();
            });
            btnE.setOnClickListener((v)->{
                Intent intent1 = new Intent();
                intent1.putExtra("name",intent.getStringExtra("name"));
                intent1.putExtra("family",intent.getStringExtra("family"));
                intent1.putExtra("mail",intent.getStringExtra("mail"));
                intent1.putExtra("phone",intent.getStringExtra("phone"));
                setResult(Activity.RESULT_OK,intent1);
                finish();
            });
        }


    }

}
