//package com.example.ferret.Activity;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.ferret.Adapter.FramesAdapter;
//import com.example.ferret.Domain.FramesDomain;
//import com.example.ferret.Login;
//import com.example.ferret.R;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.navigation.NavigationView;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    private RecyclerView.Adapter adapterFramesList;
//    private RecyclerView recyclerViewFrames;
//
//    TextView mTextViewUsername;
//    SharedPreferences mSharedPreferences;
//
//
//
//
//    private DrawerLayout mDrawerLayout;
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
////        initRecyclerView();
//        BottomNavigation();
//
//        mTextViewUsername = findViewById(R.id.textView_userName);
//
//        Intent mIntent = getIntent();
//        if(mIntent.hasExtra("EXTRA_USER_NAME")) {
//            mTextViewUsername.setText((mIntent.getStringExtra("EXTRA_USER_NAME")));
//
//
//        }
//    }
//
//
//
//    private void BottomNavigation() {
//        LinearLayout profileBtn=findViewById(R.id.profileBtn);
//        profileBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
//            }
//        });
//    }
//
//
////    private void initRecyclerView() {
////        ArrayList<FramesDomain> items = new ArrayList<>();
////
////        items.add(new FramesDomain("Future in AI, What will tomorrow be like?", "The National","trends"));
////        items.add(new FramesDomain("Important points in concluding a word contract" , "Reuters","trends2"));
////        items.add(new FramesDomain("Future in AI, What will tomorrow be like?", "The National","trends"));
////
////        recyclerViewFrames=findViewById(R.id.view1);
////        recyclerViewFrames.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
////
////        adapterFramesList = new FramesAdapter(items);
////        recyclerViewFrames.setAdapter(adapterFramesList);
////
////    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        return false;
//    }
//}