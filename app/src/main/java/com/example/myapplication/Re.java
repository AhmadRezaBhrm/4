package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Re extends AppCompatActivity {

    EditText name;
    EditText family;
    EditText mail;
    EditText phone;

    Button btn_preview;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r);
        btn_preview = findViewById(R.id.btn_preview);
        btn_back = findViewById(R.id.btn_back);

        name = findViewById(R.id.edt_name);
        family = findViewById(R.id.edt_family);
        mail = findViewById(R.id.edt_mail);
        phone = findViewById(R.id.edt_phone);

        btn_preview.setOnClickListener((v)->{
            Intent intent = new Intent(Re.this,Information.class);
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("family",family.getText().toString());
            intent.putExtra("mail",mail.getText().toString());
            intent.putExtra("phone",phone.getText().toString());
            intent.putExtra("flag","0");
            startActivityForResult(intent,113);


        });
        btn_back.setOnClickListener((v)->{
            Intent intent = new Intent(Re.this,Drawer.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 113){
            if (resultCode == Activity.RESULT_OK){
                name.setText(data.getStringExtra("name"));
                family.setText(data.getStringExtra("family"));
                mail.setText(data.getStringExtra("mail"));
                phone.setText(data.getStringExtra("phone"));
            }
        }
    }

}
