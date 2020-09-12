package com.rocktech.gads;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SkillViewAdapter extends RecyclerView.Adapter<SkillViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<User> users;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_skill, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.name.append(users.get(position).getName());
        holder.detail.append(users.get(position).getHours()+"  Skill IQ Score, "+users.get(position).getCountry());
//        holder.name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View scroll_view) {
//              //  Toast.makeText(context, users.get(position).getName()+" selected", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,detail;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.userName);
            detail = itemView.findViewById(R.id.detail);
          //  itemView.setOnClickListener(this);
        }
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
       notifyDataSetChanged();
    }
}
