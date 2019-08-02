package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

public class Drawer extends AppCompatActivity {

    Button btnRegister;
    Button btnProfile;
    Button open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        btnRegister = findViewById(R.id.btnRegister);
        btnProfile = findViewById(R.id.btnProfile);
        open = findViewById(R.id.open);
        open.setOnClickListener((v)->{
            DrawerLayout drawer = findViewById(R.id.DrawerLayout);
            if (drawer.isDrawerOpen(Gravity.RIGHT))
                drawer.closeDrawer(Gravity.RIGHT);
            else
                drawer.openDrawer(Gravity.RIGHT);
        });
        btnRegister.setOnClickListener((v)->{
            Intent intent = new Intent(Drawer.this,Re.class);
            startActivity(intent);
        });
        btnProfile.setOnClickListener((v)->{
            Intent intent = new Intent(Drawer.this,Information.class);
            intent.putExtra("flag","1");
            startActivity(intent);
        });
    }
}
