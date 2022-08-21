package com.example.avid1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;
  //public SearchView searchView;
  public String query;
  private ImageButton button;
  List<Students>studentsList=new ArrayList<Students>();
    //List<Students> studentsList= new ArrayList<>();
  List<String>keys=new ArrayList<String>();
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private SearchView searchView;








    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        new FirebaseDatabaseHelper().read(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Students> studentsList, List<String> keys) {
                new RecyclerView_config().setConfig(mRecyclerView,MainActivity.this,studentsList,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
*/


        mRecyclerView =(RecyclerView) findViewById(R.id.RecyclerView_Avid);

        //searchView = (SearchView) findViewById(R.id.searchView);
        ImageButton button = (ImageButton) findViewById(R.id.imageButton5);
        layoutManager =new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter=new RecyclerViewAdapter(studentsList,keys,MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,com.example.avid1.MainActivity2.class);
               //MainActivity.this.startActivity(intent);
                Collections.sort(studentsList,Students.StudentNameaz);
                Query query = FirebaseDatabase.getInstance().getReference().orderByChild("Name").startAt("A").endAt("Z");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        studentsList.clear();
                        for (DataSnapshot keynode : snapshot.getChildren()){
                            keys.add(keynode.getKey());
                            Students lists = keynode.getValue(Students.class);
                            studentsList.add(lists);
                        }
                        mAdapter=new RecyclerViewAdapter(studentsList,keys,MainActivity.this);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                Toast.makeText(getApplicationContext(),"this button clicked",Toast.LENGTH_LONG).show();

            }
        });
        mDatabase= FirebaseDatabase.getInstance();
        mRef= mDatabase.getReference();
       mRef.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               studentsList.clear();
               for (DataSnapshot keynode : snapshot.getChildren()){
                   keys.add(keynode.getKey());
                   Students lists = keynode.getValue(Students.class);
                   studentsList.add(lists);
               }
               mAdapter=new RecyclerViewAdapter(studentsList,keys,MainActivity.this);
               mRecyclerView.setAdapter(mAdapter);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
   /*     ValueEventListener valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentsList.clear();
                for (DataSnapshot keynode : snapshot.getChildren()){
                    keys.add(keynode.getKey());
                    Students lists = keynode.getValue(Students.class);
                    studentsList.add(lists);
                }
                mAdapter=new RecyclerViewAdapter(studentsList,keys,MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
*/



       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Query query = FirebaseDatabase.getInstance().getReference().orderByChild("City").equalTo(s);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        studentsList.clear();
                        for (DataSnapshot keynode : snapshot.getChildren()){
                            keys.add(keynode.getKey());
                            Students lists = keynode.getValue(Students.class);
                            studentsList.add(lists);
                        }
                        mAdapter=new RecyclerViewAdapter(studentsList,keys,MainActivity.this);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
               });
           return false; }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }




    }

