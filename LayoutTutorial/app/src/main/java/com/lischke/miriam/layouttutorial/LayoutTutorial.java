package com.lischke.miriam.layouttutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LayoutTutorial extends AppCompatActivity{

    RecyclerView rv;
    private List<Person> persons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tutorial);

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

    }


    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
    }


}
