package com.example.csiemessagingappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagingActivity extends AppCompatActivity {

    TextView username;
    CircleImageView profile_image;
    Intent intent;
    ImageButton btn_send_msg;
    EditText text_send_msg;

    /// Firebase related fields
    FirebaseUser firebaseUser;
    DatabaseReference reference;

    ////

    //// Adapter for showing the received/sent messages

    AdapterShowMessages messagesAdapter;
    List<Chat> mChat;
    RecyclerView showMsgRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        /// Setting the toolbar
        Toolbar toolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ///

        ///
        showMsgRecycler = findViewById(R.id.recycler_view_conv);
        showMsgRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        showMsgRecycler.setLayoutManager(linearLayoutManager);



        profile_image = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        btn_send_msg = findViewById(R.id.btn_send_msg);
        text_send_msg = findViewById(R.id.text_sent);


        intent = getIntent();

        final String userid = intent.getStringExtra("userid");
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        ///


        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = text_send_msg.getText().toString();
                if(!message.equals(""))
                {
                    sendTheMessage(firebaseUser.getUid(), userid, message);
                }
                else
                {
                    Toast.makeText(MessagingActivity.this, "You cannot send an empty text message!", Toast.LENGTH_LONG).show();
                }
                text_send_msg.setText("");
            }
        });





        reference = FirebaseDatabase.getInstance().getReference("User").child(userid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")) {
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                }
                else
                {
                    Glide.with(MessagingActivity.this).load(user.getImageURL()).into(profile_image);
                }

                readTheMessages(firebaseUser.getUid(), userid, user.getImageURL());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sendTheMessage(String sender, String receiver, String message) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sender", sender);
        hashMap.put("receiver", receiver);
        hashMap.put("message", message);

        reference.child("Chats").push().setValue(hashMap);
    }

    private void readTheMessages(final String myID, final String userID, final String imageURL) {
        mChat = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chats"); // currentID = myId
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mChat.clear();
                for (DataSnapshot theDataSnapshot : dataSnapshot.getChildren()) {
                    Chat conversation = theDataSnapshot.getValue(Chat.class);


                    if(conversation.getReceiver().equals(myID) && conversation.getSender().equals(userID) ||
                    conversation.getReceiver().equals(userID) && conversation.getSender().equals(myID)) {
                        mChat.add(conversation);
                    }
                    messagesAdapter = new AdapterShowMessages(MessagingActivity.this, mChat, imageURL);
                    showMsgRecycler.setAdapter(messagesAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
