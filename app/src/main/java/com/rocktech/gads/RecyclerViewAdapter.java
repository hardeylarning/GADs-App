package com.rocktech.gads;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private List<TopHour> topHours;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.name.setText(topHours.get(position).getName());
        holder.detail.setText(topHours.get(position).getHours()+" learning hours, "+topHours.get(position).getCountry());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(context, users.get(position).getName()+" selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return topHours.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,detail;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.topUserImage);
            name = itemView.findViewById(R.id.topUserName);
            detail = itemView.findViewById(R.id.topUserDetail);
        }
    }
    public void setUsers(List<TopHour> topHours){
        this.topHours = topHours;
        notifyDataSetChanged();
    }
}
