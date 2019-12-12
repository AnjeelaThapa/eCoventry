package com.example.ecoventry.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecoventry.MainActivity;
import com.example.ecoventry.AdapterActivity;
import com.example.ecoventry.R;
import com.example.ecoventry.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    List<Student> students = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView=root.findViewById(R.id.rvstudents);

        if(MainActivity.st.isEmpty()) {
            MainActivity.st.add(new Student("Anjeela", "Female", "19", "Nepal"));
            MainActivity.st.add(new Student("Sama", "Female", "20", "KTM"));
            MainActivity.st.add(new Student("Seokjin", "Male", "23", "KTM"));
            MainActivity.st.add(new Student("Dikshya", "Female", "22", "Hetauda"));
            MainActivity.st.add(new Student("Taeyung", "Male", "22", "Pokhara"));

            AdapterActivity adapter = new AdapterActivity(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager);


            recyclerView.setAdapter(adapter);
        }else {

            AdapterActivity adapter2 = new AdapterActivity(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager2);


            recyclerView.setAdapter(adapter2);
        }



        return root;
    }
}