package com.gather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class myProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        final TextView Art, Design, Leadership, Java, Python, CSharp, Windows, Linux, OSX, Android, IOS, CPP, HTML;
        Art = (TextView) findViewById(R.id.textArt);
        Leadership = (TextView) findViewById(R.id.textLeadership);
        Design = (TextView) findViewById(R.id.textDesign);
        Java = (TextView) findViewById(R.id.textJava);
        Python = (TextView) findViewById(R.id.textPython);
        CSharp = (TextView) findViewById(R.id.textCSharp);
        Windows = (TextView) findViewById(R.id.textWindows);
        Linux = (TextView) findViewById(R.id.textLinux);
        OSX = (TextView) findViewById(R.id.textOSX);
        Android = (TextView) findViewById(R.id.textAndroid);
        IOS = (TextView) findViewById(R.id.textIOS);
        CPP = (TextView) findViewById(R.id.textCPP);
        HTML = (TextView) findViewById(R.id.textHTML);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userInfo = ref.child("users").child(uid);
        userInfo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                ArrayList list = user.getLevels();
                Art.setText("Art: "+String.valueOf(list.get(0)));
                Design.setText("Design: "+String.valueOf(list.get(1)));
                Leadership.setText("Leadership: "+String.valueOf(list.get(2)));
                Java.setText("Java: "+String.valueOf(list.get(3)));
                Python.setText("Python: "+String.valueOf(list.get(4)));
                CSharp.setText("C#: "+String.valueOf(list.get(5)));
                Windows.setText("Windows: "+String.valueOf(list.get(6)));
                Linux.setText("Linux: "+String.valueOf(list.get(7)));
                OSX.setText("OSX: "+String.valueOf(list.get(8)));
                Android.setText("Android: "+String.valueOf(list.get(9)));
                IOS.setText("IOS: "+String.valueOf(list.get(10)));
                CPP.setText("C++: "+String.valueOf(list.get(11)));
                HTML.setText("HTML: "+String.valueOf(list.get(12)));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
