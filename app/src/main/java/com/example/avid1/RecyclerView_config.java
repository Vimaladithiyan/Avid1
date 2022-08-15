package com.example.avid1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_config {
    private Context mContext;
    private listAdapter mListAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Students>list,List<String>keys){
     mContext=context;
     mListAdapter = new listAdapter(list,keys);
     recyclerView.setLayoutManager(new LinearLayoutManager(context));
     recyclerView.setAdapter(mListAdapter);
    }



    class StudentItemView extends RecyclerView.ViewHolder{
        private TextView name_text;
        private TextView Rank_text;
        private String key;

        public StudentItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));
            name_text=(TextView) itemView.findViewById(R.id.textView3);
            Rank_text=(TextView) itemView.findViewById(R.id.textView4);

        }
       public void bind(Students list,String key){
            name_text.setText(list.getName());
            Rank_text.setText(list.getRank());
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
