package com.example.csiemessagingappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar mToolbar;
    private ViewPager mViewPager;
    private AdapterPagerSections mAdapterPagerSections; //ADAPTER for the fragment pages
    private TabLayout mTabLayout;
    CircleImageView profile_image; // Avatar
    TextView username;
    //Firebase related fields
    FirebaseUser firebaseUser;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Setting the toolbar
        mToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle("Messaging app");
        getSupportActionBar().setTitle("");
        ///

        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        username = (TextView) findViewById(R.id.username);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText("Logged in as: " + user.getUsername());
                if(user.getImageURL().equals("default")) {
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                }
                else
                {
                    Glide.with(MainActivity.this).load(user.getImageURL()).into(profile_image); // This is a library for faster image loading
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        ////Tabs for our main activity/Message app
        mViewPager = (ViewPager) findViewById(R.id.main_tabsPager);
        /////// Adapter pager/fragments
        mAdapterPagerSections = new AdapterPagerSections(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapterPagerSections);
        mTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //Method to send the user back to the start activity
    private void sendBackToStart() {

        Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(startIntent);
        finish();
    }


    /// For the options menu
    /// !!! Currently only "Log Out" button is implemented

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.main_logout_btn)
        {
            FirebaseAuth.getInstance().signOut(); //Log out
            sendBackToStart();

        }
        if(item.getItemId() == R.id.show_gmaps_location)
        {
            startActivity(new Intent(MainActivity.this, GMapsActivity.class));

        }
        return true;
    }
}
