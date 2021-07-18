package com.example.csiemessagingappv1;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMessages extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> mUsers;

    FirebaseUser firebaseUser;

    DatabaseReference databaseReference;

    private List<String> listOfUsers;


    public FragmentMessages() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View onlyMsgView = inflater.inflate(R.layout.fragment_fragment_messages, container, false);

        recyclerView = onlyMsgView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        listOfUsers = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Chats");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                listOfUsers.clear();

                for (DataSnapshot dataSnapshotIndex : dataSnapshot.getChildren()) {

                    Chat conversation = dataSnapshotIndex.getValue(Chat.class);

                    assert conversation != null;

                    if (conversation.getReceiver().equals(firebaseUser.getUid())) {

                        listOfUsers.add(conversation.getSender());

                    }
                    if (conversation.getSender().equals(firebaseUser.getUid())) {

                        listOfUsers.add(conversation.getReceiver());
                    }
                }

                Set<String> hashSet = new HashSet<String>(listOfUsers);
                listOfUsers.clear();
                listOfUsers.addAll(hashSet);



                ///////// Code for reading the chats
                mUsers = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("User");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //mUsers.clear();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            User user = snapshot.getValue(User.class);

                            for (String id : listOfUsers) {

                                assert user != null;
                                if (user.getId().equals(id)) {
                                    mUsers.add(user);
                                }
                            }
                        }

                        userAdapter = new UserAdapter(getContext(), mUsers);
                        recyclerView.setAdapter(userAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return onlyMsgView;
    }
}