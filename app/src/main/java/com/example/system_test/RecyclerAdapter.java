package com.example.system_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id,name,email,password;

    public RecyclerAdapter(Context context, ArrayList id, ArrayList name, ArrayList email, ArrayList password) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvID.setText(String.valueOf(id.get(position)));
        holder.tvName.setText(String.valueOf(name.get(position)));
        holder.tvEmail.setText(String.valueOf(email.get(position)));
        holder.tvPassword.setText(String.valueOf(password.get(position)));





    }

    @Override
    public int getItemCount() {
        return id.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvID,tvName,tvEmail,tvPassword;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPassword = itemView.findViewById(R.id.tvPassword);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Ayaw kol!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
