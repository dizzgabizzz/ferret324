package com.example.ferret.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ferret.R;
import com.example.ferret.SingUp2;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

//    Button ButtonBack;


    TextView mTextViewUsername;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);



        mTextViewUsername = findViewById(R.id.textView8);

        Intent mIntent = getIntent();
        if(mIntent.hasExtra("EXTRA_USER_NAME")) {
            mTextViewUsername.setText((mIntent.getStringExtra("EXTRA_USER_NAME")));



//        ButtonBack = findViewById(R.id.back_home);
//        ButtonBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });


            }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}


