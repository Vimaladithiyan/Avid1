package com.example.avid1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<Students>studentsList;
   /* List<String>key;
    Context context;*/

    public RecyclerViewAdapter(List<Students> studentsList, List<String> key, Context context) {
        this.studentsList = studentsList;
       /* this.key = key;
        this.context = context;*/
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder holder= new MyViewHolder(view);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Students students=studentsList.get(position);
        holder.name_text.setText(students.getName());
        holder.Rank_text.setText(String.valueOf(students.getRank()));
        Picasso.get().load(students.getImage_url()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name_text;
        private TextView Rank_text;
        private ImageView image;
        private Button button;
        private String key;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text=(TextView) itemView.findViewById(R.id.textView3);
            Rank_text=(TextView) itemView.findViewById(R.id.textView4);
            image = (ImageView) itemView.findViewById(R.id.imageview1);
            button=(Button)  itemView.findViewById(R.id.button);

        }
    }

}
