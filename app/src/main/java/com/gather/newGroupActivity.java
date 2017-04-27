package com.gather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class newGroupActivity extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    User me = new User();
    ArrayList<User> userList = new ArrayList<>();

    private Button btnCreateGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        final TextView courseNum, secNum;
        final EditText groupSize;
        btnCreateGroup = (Button) findViewById(R.id.btn_createNewGroup);
        groupSize = (EditText) findViewById(R.id.editTextGroupSize);
        courseNum = (TextView) findViewById(R.id.textCourseNum);
        secNum = (TextView) findViewById(R.id.textSecNum);

        Toast.makeText(newGroupActivity.this, "You can change your course and section numbers under MyProfile.", Toast.LENGTH_SHORT).show();

        String id = auth.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userInfo = ref.child("users").child(id);
        userInfo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                me = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (me != null) {
                    ArrayList list = me.getLevels();
                    int counter = 0;
                    for (int i = 0; i <= list.size() - 1; i++) {
                        if (list.get(i).equals(0))
                            counter++;
                    }
                    if (counter == list.size())
                        Toast.makeText(newGroupActivity.this, "You're horrible. At like, everything. Go change your skill levels under MyProfile.", Toast.LENGTH_SHORT).show();
                    else {
                        try {
                            if (makeNewGroup(Integer.parseInt(groupSize.getText().toString()), userList))
                                Toast.makeText(newGroupActivity.this, "Your group new group has been created, check it out under MyGroup", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(newGroupActivity.this, "When we said \"Enter a Group Size\" we meant more than 0. Idiot. Go back and do it again.", Toast.LENGTH_SHORT).show();
                        } catch (NumberFormatException e) {
                            Toast.makeText(newGroupActivity.this, "Enter a group size.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        //Get datasnapshot at your "users" root node
        DatabaseReference allUserRef = FirebaseDatabase.getInstance().getReference().child("users");
        allUserRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user_this = dataSnapshot.getValue(User.class);
                userList.add(user_this);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public Boolean makeNewGroup(int groupSize, ArrayList<User> user) {
        if (groupSize>0) {
            String groupKey = makeGroupKey();
            for (User usr:user) {
                changeGroup(groupKey,usr.getUid());
            }
            return true;
        }
        return false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(newGroupActivity.this, MainActivity.class));
        finish();
    }
    public void changeData(int val, String str) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(auth.getCurrentUser().getUid()).child(str);
        ref.setValue(val);
    }
    public void changeGroup(String group, String uid) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("groupName");
        ref.setValue(group);
        ref = FirebaseDatabase.getInstance().getReference().child("Groups").child(group);
        ref.setValue(group);
    }
    protected String makeGroupKey() {
        String ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();
        while (key.length() < 28) { // length of the group key.
            int index = (int) (rnd.nextFloat() * ALPH.length());
            key.append(ALPH.charAt(index));
        }
        String groupKey = key.toString();
        return groupKey;
    }
}