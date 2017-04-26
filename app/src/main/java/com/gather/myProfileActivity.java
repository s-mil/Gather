package com.gather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
        final String[] vals = new String [] {"Change your skill level","0","1","2","3","4","5","6","7","8","9","10"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerchangeArt ,spinnerchangeDesign ,spinnerchangeLeadership ,spinnerchangeJava ,spinnerchangePython ,spinnerchangeCSharp ,spinnerchangeWindows ,spinnerchangeLinux ,spinnerchangeOSX ,spinnerchangeAndroid ,spinnerchangeIOS ,spinnerchangeCPP ,spinnerchangeHTML;
        spinnerchangeArt = (Spinner) findViewById(R.id.spinner_Art);
        spinnerchangeDesign = (Spinner) findViewById(R.id.spinner_Design);
        spinnerchangeLeadership = (Spinner) findViewById(R.id.spinner_Leadership);
        spinnerchangeJava = (Spinner) findViewById(R.id.spinner_Java);
        spinnerchangePython = (Spinner) findViewById(R.id.spinner_Python);
        spinnerchangeCSharp = (Spinner) findViewById(R.id.spinner_CSharp);
        spinnerchangeWindows = (Spinner) findViewById(R.id.spinner_Windows);
        spinnerchangeLinux = (Spinner) findViewById(R.id.spinner_Windows);
        spinnerchangeOSX = (Spinner) findViewById(R.id.spinner_OSX);
        spinnerchangeAndroid = (Spinner) findViewById(R.id.spinner_Android);
        spinnerchangeIOS = (Spinner) findViewById(R.id.spinner_IOS);
        spinnerchangeCPP = (Spinner) findViewById(R.id.spinner_CPP);
        spinnerchangeHTML = (Spinner) findViewById(R.id.spinner_HTML);

        spinnerchangeArt.setAdapter(adapter);
        spinnerchangeArt.setSelection(0);
        spinnerchangeDesign.setAdapter(adapter);spinnerchangeDesign.setSelection(0);
        spinnerchangeLeadership.setAdapter(adapter);spinnerchangeLeadership.setSelection(0);
        spinnerchangeJava.setAdapter(adapter);spinnerchangeJava.setSelection(0);
        spinnerchangePython.setAdapter(adapter);spinnerchangePython.setSelection(0);
        spinnerchangeCSharp.setAdapter(adapter);spinnerchangeCSharp.setSelection(0);
        spinnerchangeWindows.setAdapter(adapter);spinnerchangeWindows.setSelection(0);
        spinnerchangeLinux.setAdapter(adapter);spinnerchangeLinux.setSelection(0);
        spinnerchangeOSX.setAdapter(adapter);spinnerchangeOSX.setSelection(0);
        spinnerchangeAndroid.setAdapter(adapter);spinnerchangeAndroid.setSelection(0);
        spinnerchangeIOS.setAdapter(adapter);spinnerchangeIOS.setSelection(0);
        spinnerchangeCPP.setAdapter(adapter);spinnerchangeCPP.setSelection(0);
        spinnerchangeHTML.setAdapter(adapter);spinnerchangeHTML.setSelection(0);




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

        String uid = auth.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userInfo = ref.child("users").child(uid);
        userInfo.addValueEventListener(new ValueEventListener() {
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
        spinnerchangeArt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"ArtLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeDesign.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"DesignLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeLeadership.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"LeadershipLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeJava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"JavaLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangePython.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"PythonLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeCSharp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"CSharpLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeWindows.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"WindowsLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeLinux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"LinuxLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeOSX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"OSXLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeAndroid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"AndroidLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeIOS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"IOSLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeCPP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"CPPLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerchangeHTML.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    changeData(position-1,"HTMLLevel");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    final FirebaseAuth auth = FirebaseAuth.getInstance();
    public void changeData (int val, String str) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(auth.getCurrentUser().getUid()).child(str);
        ref.setValue(val);
    }
}
