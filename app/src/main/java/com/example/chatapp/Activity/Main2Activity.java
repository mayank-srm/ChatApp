package com.example.chatapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.chatapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private FirebaseAuth mAuth;
    private ViewPager mViewPager;
    private SectionPagerAdapter nSectionsPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();
        mtoolbar =  findViewById(R.id.app_bar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Chat App");

        mViewPager = findViewById(R.id.main_page);
        nSectionsPagerAdapter =new SectionPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(nSectionsPagerAdapter);

        mTabLayout = findViewById(R.id.tab_bar);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            Intent startIntent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(startIntent);
            finish();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(Main2Activity.this, "SIGNED OUT SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            Intent startIntent = new Intent(Main2Activity.this, LoginScreen.class);
            startActivity(startIntent);
        }
        else if(item.getItemId() == R.id.ac_settings){

            Intent account_setting = new Intent (Main2Activity.this , SettingsActivity.class);
            startActivity(account_setting);

        }
        else if(item.getItemId() == R.id.all_users){



            Intent AllUsers = new Intent(Main2Activity.this, UsersActivity.class);
            startActivity(AllUsers);

        }
        return true;
    }


}
