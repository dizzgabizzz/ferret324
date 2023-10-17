package com.example.ferret.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ferret.Login;
import com.example.ferret.R;
import com.example.ferret.SingUp2;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        ButtonBack();
        ButtonLogout();

    }

    private void ButtonLogout() {
        ConstraintLayout Logout=findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, Login.class));
            }
        });
    }

    private void ButtonBack() {
        ConstraintLayout back_home=findViewById(R.id.back_home);
        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
    }

    public void Logout(View view){
        logoutMenu(ProfileActivity.this);
    }

    private void logoutMenu (ProfileActivity profileActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(profileActivity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

}


