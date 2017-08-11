package com.sylvester.android.sylvesterfrancis.adapters;

/**
 * Created by sylvester on 30/07/17.
 */

/* Contact me Adapter */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sylvester.android.sylvesterfrancis.R;
import com.sylvester.android.sylvesterfrancis.data.Contact;

import java.util.List;

/**
 * Created by sylvester on 30/07/17.
 */

public class ContactMeAdapter extends RecyclerView.Adapter<ContactMeAdapter.ContactViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;

 public class ContactViewHolder extends RecyclerView.ViewHolder {

     public EditText Name,Email,Subject,Message;
     public String name,email,subject,message;
     public Button submit_button;
     private FirebaseDatabase mFirebaseDatabase;
     private DatabaseReference mContactsDatabaseReference;
     public static final String FIREBASE_URL = "https://mycvapp-b4ae1.firebaseio.com/";
     Contact contact = new Contact();


    public ContactViewHolder(View view) {
        super(view);
        //Firebase.setAndroidContext(view.getContext());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mContactsDatabaseReference = mFirebaseDatabase.getReference().child("Contact");
        Name = view.findViewById(R.id.your_name);
        Email = view.findViewById(R.id.your_email);
        Subject= view.findViewById(R.id.your_subject);
        Message = view.findViewById(R.id.your_message);
        submit_button = view.findViewById(R.id.post_message);
    }
 }

    public ContactMeAdapter(List<Object> contents) {
        this.contents = contents;}

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_HEADER;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }




    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.contactform_layout, parent, false);
                return new ContactViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        holder.submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(holder.Name.getText().toString(),holder.Email.getText().toString(),holder.Subject.getText().toString(),holder.Message.getText().toString());
                holder.mContactsDatabaseReference.push().setValue(contact);
                holder.Name.setText("");
                holder.Email.setText("");
                holder.Message.setText("");
                holder.Subject.setText("");

            }
        });

        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
        }
    }

}
