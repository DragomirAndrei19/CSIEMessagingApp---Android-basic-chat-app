package com.example.csiemessagingappv1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


// Almost identical to UserAdapter
public class AdapterShowMessages extends RecyclerView.Adapter<AdapterShowMessages.ViewHolder> {


    /// Firebase related code

    FirebaseUser firebaseUser;


    public static final int TYPE_MSG_LEFT = 0;
    public static final int TYPE_MSG_RIGHT = 1;
    private Context mContext;
    private String imageURL;
    private List<Chat> mChat;

    public AdapterShowMessages(Context mContext, List<Chat> mChat, String imageURL) {
        this.mChat = mChat;
        this.imageURL = imageURL;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterShowMessages.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == TYPE_MSG_RIGHT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_right_item, parent, false);
            return new AdapterShowMessages.ViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_left_item, parent, false);
            return new AdapterShowMessages.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterShowMessages.ViewHolder holder, int position) {

        Chat conversation = mChat.get(position);

        holder.show_the_message.setText(conversation.getMessage());

        if(imageURL.equals("default")) {
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        }
        else
        {
            Glide.with(mContext).load(imageURL).into(holder.profile_image);
        }

    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView profile_image;
        public TextView show_the_message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            show_the_message = itemView.findViewById(R.id.show_message);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }


    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(mChat.get(position).getSender().equals(firebaseUser.getUid())) {
            return TYPE_MSG_RIGHT; // show the messages in the right part of the screen
        }
        else
        {
            return TYPE_MSG_LEFT; // show the messages in the left part of the screen
        }
    }
}
