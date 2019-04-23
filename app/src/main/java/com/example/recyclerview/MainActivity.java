package com.example.recyclerview;

import android.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<person>people;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        btnadd=findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new person("Dristi","saima","plane"));
                myAdapter.notifyDataSetChanged();

            }
        });

        //layoutManager=new LinearLayoutManager(this);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        layoutManager=new GridLayoutManager(this,2 ,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        people= new ArrayList<person>();
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","plane"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","plane"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","plane"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","plane"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","bus"));
        people.add(new person("shakil","islam","plane"));

        myAdapter=new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"surname"+people.get(index).getSurname(),Toast.LENGTH_SHORT).show();

    }
}
