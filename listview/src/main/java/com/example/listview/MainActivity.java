package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> dataset = new ArrayList<>();
        dataset.add("Android");
        dataset.add("Ios");
        dataset.add("Symbian");
        dataset.add("Windows");
        dataset.add("Bada");
        dataset.add("Rim");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dataset);
        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);
    }
}
