package com.example.jiyeyu_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = getResources().getStringArray(R.array.starr);

        //Bridge
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list, arr);

        listView = findViewById(R.id.listview1);
        listView.setAdapter(adapter);



        //Intent intent = new Intent(getActivity(), MainActivity.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = listView.getItemAtPosition(i).toString();
                if (item.equals("Exercise 1"))
                    startActivity(new Intent(getApplicationContext(),
                            Exercise1.class));

                else if (item.equals("Exercise 2"))
                    startActivity(new Intent(getApplicationContext(),
                            Exercise2.class));

                else if (item.equals("Exercise 3"))

                    startActivity(new Intent(getApplicationContext(),
                            Exercise3.class));


            }
        });

    }

}