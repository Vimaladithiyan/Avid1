package com.example.avid1;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    StorageReference storageReference;
    private List<Students>list=new ArrayList<>();
    public interface DataStatus{
     void DataIsLoaded(List<Students>list,List<String>keys);
     void DataIsInserted();
     void DataIsUpdated();
     void DataIsDeleted();



    }

    public FirebaseDatabaseHelper() {
        mDatabase= FirebaseDatabase.getInstance();
        mRef= mDatabase.getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

    }
    public void read( final DataStatus dataStatus){
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                List<String>keys=new ArrayList<>();

                for (DataSnapshot keynode : snapshot.getChildren()){
                    keys.add(keynode.getKey());
                    Students lists = keynode.getValue(Students.class);
                    list.add(lists);
                }
                dataStatus.DataIsLoaded(list,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
