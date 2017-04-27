package com.gather;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import com.firebase.ui.database.FirebaseRecyclerAdapter;


public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSend;
    private EditText edtMessage;
    private RecyclerView rvMessage;
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

//    private AppPreference mAppPreference;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private FirebaseRecyclerAdapter<Message, ChatViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btnSend = (Button) findViewById(R.id.btn_send_message);
        btnSend.setOnClickListener(this);

        edtMessage = (EditText) findViewById(R.id.edit_message);
        rvMessage = (RecyclerView) findViewById(R.id.recycler_view_chat);
        rvMessage.setHasFixedSize(true);
        rvMessage.setLayoutManager(new LinearLayoutManager(this));

//        mAppPreference = new AppPreference(this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();

        adapter = new FirebaseRecyclerAdapter<Message, ChatViewHolder>(
                Message.class,
                R.layout.row_group,
                ChatViewHolder.class,
                mDatabaseReference.child("Groups").child("group3")
        ) {
            @Override
            protected void populateViewHolder(ChatViewHolder viewHolder, Message model, int position) {
                viewHolder.tvMessage.setText(model.message);
                viewHolder.tvEmail.setText(model.sender);
            }
        };
        rvMessage.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_message){
            String message = edtMessage.getText().toString().trim();
            if (!TextUtils.isEmpty(message)){
                Map<String, Object> param = new HashMap<>();
                param.put("sender", email);
                param.put("message", message);

                mDatabaseReference.child("Groups").child("group3")
                        .push()
                        .setValue(param)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                          public void onComplete(@NonNull Task<Void> task) {
                                edtMessage.setText("");
                                if(task.isSuccessful()){
                                    Log.d("SendMessage", "Success");
                                }else{
                                    Log.d("SendMessage", "failed ");
                                }
                            }
                        });
                if (adapter.getItemCount() > 0)
                    rvMessage.getLayoutManager().smoothScrollToPosition(rvMessage, null, adapter.getItemCount() - 1);
            }
        }
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {

        TextView tvEmail, tvMessage;

        public ChatViewHolder(View itemView) {
            super(itemView);

            tvEmail = (TextView) itemView.findViewById(R.id.tv_sender);
            tvMessage = (TextView) itemView.findViewById(R.id.view_message);
        }
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(MessageActivity.this, MainActivity.class));
        finish();
    }

}
