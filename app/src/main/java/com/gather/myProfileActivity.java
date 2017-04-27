package com.gather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class myProfileActivity extends AppCompatActivity {
    final FirebaseAuth auth = FirebaseAuth.getInstance();
    private Button btnChangeDisplayName, btnSkills, btnLeaveGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        final TextView myGroup;
        final EditText displayName;
        displayName = (EditText) findViewById(R.id.editTextDisplayName);
        myGroup = (TextView) findViewById(R.id.textGroup);
        btnChangeDisplayName = (Button) findViewById(R.id.btn_ChangeDisplayName);
        btnSkills = (Button) findViewById(R.id.btn_ViewSkills);
        btnLeaveGroup = (Button) findViewById(R.id.btn_leaveGroup);


        String uid = auth.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userInfo = ref.child("users").child(uid);
        userInfo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                displayName.setHint(user.getdisplayName());
                myGroup.setText("My Group " + user.getGroupName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        btnChangeDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = displayName.getText().toString();
                changeData(name, "displayName");
                Toast.makeText(myProfileActivity.this, "Display Name Changed", Toast.LENGTH_SHORT).show();
            }
        });
        btnSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myProfileActivity.this, mySkillsActivity.class));
            }
        });
        btnLeaveGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myProfileActivity.this, "You leave the group when I say you leave the group. Bitch.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void changeData (String val, String str) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(auth.getCurrentUser().getUid()).child(str);
        ref.setValue(val);
    }
}
