package com.example.avid1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecyclerView_config {
    private Context mContext;
    private listAdapter mListAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Students>list,List<String>keys){
        Collections.sort(list, new Comparator<Students>() {
            @Override
            public int compare(Students students, Students t1) {
                return students.getName().compareTo(t1.getName());
            }

        });
     mContext=context;
     mListAdapter = new listAdapter(list,keys);
     recyclerView.setLayoutManager(new LinearLayoutManager(context));
     recyclerView.setAdapter(mListAdapter);
     mListAdapter.notifyDataSetChanged();
    }



    class StudentItemView extends RecyclerView.ViewHolder{
        private TextView name_text;
        private TextView Rank_text;
        private ImageView image;
        private String key;

        public StudentItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));
            name_text=(TextView) itemView.findViewById(R.id.textView3);
            Rank_text=(TextView) itemView.findViewById(R.id.textView4);
            image = (ImageView) itemView.findViewById(R.id.imageview1);


        }
       public void bind(Students list,String key){
            name_text.setText(list.getName());
            Rank_text.setText(""+list.getRank());
            Picasso.get().load(list.getImage_url()).into(image);


            //Glide.with
            this.key=key;

       }

    }
    class listAdapter extends RecyclerView.Adapter<StudentItemView>{
    private List<Students>StudentList;
    private List<String>mKeys;



        public listAdapter(List<Students> studentList, List<String> mKeys) {
            this.StudentList = studentList;

            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public StudentItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new StudentItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentItemView holder, int position) {
            holder.bind(StudentList.get(position),mKeys.get(position));



        }

        @Override
        public int getItemCount() {
            return StudentList.size();
        }
    }

}
