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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class newGroupActivity extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    ArrayList<User> userList = new ArrayList<>();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    String uid = auth.getCurrentUser().getUid();
    DatabaseReference userInfo = ref.child("users").child(uid);
    User item = new User();
    ArrayList<User> list = new ArrayList<>();
    User usr;

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

        userInfo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usr = dataSnapshot.getValue(User.class);
//                courseNum.setText(usr.getCourseNum);
//                secNum.setText(usr.getSecNum);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        btnCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = Integer.parseInt(groupSize.getText().toString());
            }
        });

        //Get datasnapshot at your "users" root node
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }

    private ArrayList<User> collectUsers(Map<String, Object> users) {
        //initialize an array list for each data used in User class
        ArrayList<Integer> ArtLevel = new ArrayList<>();
        ArrayList<Integer> DesignLevel = new ArrayList<>();
        ArrayList<Integer> LeadershipLevel = new ArrayList<>();
        ArrayList<Integer> JavaLevel = new ArrayList<>();
        ArrayList<Integer> PythonLevel = new ArrayList<>();
        ArrayList<Integer> CSharpLevel = new ArrayList<>();
        ArrayList<Integer> WindowsLevel = new ArrayList<>();
        ArrayList<Integer> LinuxLevel = new ArrayList<>();
        ArrayList<Integer> OSXLevel = new ArrayList<>();
        ArrayList<Integer> AndroidLevel = new ArrayList<>();
        ArrayList<Integer> IOSLevel = new ArrayList<>();
        ArrayList<Integer> CPPLevel = new ArrayList<>();
        ArrayList<Integer> HTMLLevel = new ArrayList<>();
        ArrayList<Integer> CourseNum = new ArrayList<>();
        ArrayList<Integer> SectionNum = new ArrayList<>();
        ArrayList<Integer> inGroup = new ArrayList<>();
        ArrayList<String> groupName = new ArrayList<>();
        ArrayList<String> displayName = new ArrayList<>();
        ArrayList<String> uid = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()) {
            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get Art Level field and append to list
            //Rinse and repeat for other values
            ArtLevel.add((Integer) singleUser.get("ArtLevel"));
            DesignLevel.add((Integer) singleUser.get("DesignLevel"));
            LeadershipLevel.add((Integer) singleUser.get("LeadershipLevel"));
            JavaLevel.add((Integer) singleUser.get("JavaLevel"));
            PythonLevel.add((Integer) singleUser.get("PythonLevel"));
            CSharpLevel.add((Integer) singleUser.get("CSharpLevel"));
            WindowsLevel.add((Integer) singleUser.get("WindowsLevel"));
            LinuxLevel.add((Integer) singleUser.get("LinuxLevel"));
            OSXLevel.add((Integer) singleUser.get("OSXLevel"));
            AndroidLevel.add((Integer) singleUser.get("AndroidLevel"));
            IOSLevel.add((Integer) singleUser.get("IOSLevel"));
            CPPLevel.add((Integer) singleUser.get("CPPLevel"));
            HTMLLevel.add((Integer) singleUser.get("HTMLLevel"));
            CourseNum.add((Integer) singleUser.get("CourseNum"));
            SectionNum.add((Integer) singleUser.get("SectionNum"));
            inGroup.add((Integer) singleUser.get("inGroup"));
            groupName.add((String) singleUser.get("groupName"));
            displayName.add((String) singleUser.get("displayName"));
            uid.add((String) singleUser.get("uid"));
        }
        int index = -1;
        ArrayList<User> out = new ArrayList<>();
        for (String child : uid) {
            index++;
            //the longest line
            User use1 = new User(
                    ArtLevel.get(index).intValue(),
                    DesignLevel.get(index).intValue(),
                    LeadershipLevel.get(index).intValue(),
                    JavaLevel.get(index).intValue(),
                    PythonLevel.get(index).intValue(),
                    CSharpLevel.get(index).intValue(),
                    WindowsLevel.get(index).intValue(),
                    LinuxLevel.get(index).intValue(),
                    OSXLevel.get(index).intValue(),
                    AndroidLevel.get(index).intValue(),
                    IOSLevel.get(index).intValue(),
                    CPPLevel.get(index).intValue(),
                    HTMLLevel.get(index).intValue(),
                    CourseNum.get(index).intValue(),
                    SectionNum.get(index).intValue(),
                    inGroup.get(index).intValue(),
                    groupName.get(index).toString(),
                    displayName.get(index).toString(),
                    child.toString());
            out.add(use1);
        }
        return out;
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
}