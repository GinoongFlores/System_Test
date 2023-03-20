package com.example.system_test;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    AccountDatabaseHelper accountDatabaseHelper;
    RecyclerAdapter adapter;
    ArrayList<String> id,name,email,password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        accountDatabaseHelper = new AccountDatabaseHelper(getContext());

        recyclerView = v.findViewById(R.id.recycleview);
        id = new ArrayList<>();
        name = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();
        adapter = new RecyclerAdapter(getContext(),id,name,email,password);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        showData();


        return v;
    }

    private void showData() {
        Cursor res = accountDatabaseHelper.getData();
        if(res.getCount() == 0){

        }else{
            while (res.moveToNext()){
                id.add(res.getString(0));
                name.add(res.getString(1));
                email.add(res.getString(2));
                password.add(res.getString(3));
            }
        }


    }
}