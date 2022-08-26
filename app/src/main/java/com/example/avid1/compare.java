package com.example.avid1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class compare extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    public Integer Rank1;
    public Integer Rank2;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv8;
    TextView tv9;
    //public String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        String college1="Amrita Vishwa Vidyapeetham";
        String college2="Vellore Institute of Technology";
       // TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        tv1=findViewById(R.id.simpleTextView1);
        tv2=findViewById(R.id.simpleTextView2);
        tv2.setText(college1);
        tv3=findViewById(R.id.simpleTextView3);
        tv3.setText(college2);
        //String s1=""+s;

        tv5=findViewById(R.id.simpleTextView5);
        Query query = FirebaseDatabase.getInstance().getReference().orderByChild("Name").equalTo(college1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for(DataSnapshot key:snapshot.getChildren()) {
                        Students list=key.getValue(Students.class);
                        String s = list.getCity();
                        tv5.setText(s);
                        //log.d("test",s);


                    }

                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //String s1=""+s;
        tv4=findViewById(R.id.simpleTextView4);
        tv4.setText("City");
        tv6=findViewById(R.id.simpleTextView6);
        tv6.setText("test");
        Query query1 = FirebaseDatabase.getInstance().getReference().orderByChild("Name").equalTo(college2);
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot key:snapshot.getChildren()) {
                    Students list=key.getValue(Students.class);
                    String s = list.getCity();
                    tv6.setText(s);
                    //log.d("test",s);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    tv8=findViewById(R.id.simpleTextView8);
        Query query2 = FirebaseDatabase.getInstance().getReference().orderByChild("Name").equalTo(college1);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Integer rank1;
                for(DataSnapshot key:snapshot.getChildren()) {
                    Students list=key.getValue(Students.class);
                    int rank1 = list.getRank();
                    Rank1=rank1;
                    String strrank1=String.valueOf(rank1);
                    tv8.setText(strrank1);


                    //log.d("test",s);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        tv9=findViewById(R.id.simpleTextView9);
        Query query3 = FirebaseDatabase.getInstance().getReference().orderByChild("Name").equalTo(college2);
        query3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Integer rank2;
                for(DataSnapshot key:snapshot.getChildren()) {
                    Students list=key.getValue(Students.class);
                    int rank2 = list.getRank();
                    Rank2=rank2;
                    String strrank2=String.valueOf(rank2);
                    tv9.setText(strrank2);


                    //log.d("test",s);


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    /*    if(1< 2) {
            tv9.setTypeface(null, Typeface.BOLD);
        }
        else{
            tv8.setTypeface(null,Typeface.BOLD);
        }
*/








    }
}