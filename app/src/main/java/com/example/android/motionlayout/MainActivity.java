package com.example.android.motionlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //I didn't know we can also add list like this like we do with arrays
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5"));

        list.add("one");
        list.add("two");
        list.add("threre");
        list.add("fpur");
        list.add("fiev");
        list.add("one");
        list.add("two");
        list.add("threre");
        list.add("fpur");
        list.add("fiev");
        list.add("one");
        list.add("two");
        list.add("threre");
        list.add("fpur");
        list.add("fiev");


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        manager.setReverseLayout(false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new CustomAdapter(MainActivity.this,list));
    }
}
