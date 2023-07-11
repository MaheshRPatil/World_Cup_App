package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;

    ArrayList<CountryModelClass> dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.Adapter View = a listView
        listView=findViewById(R.id.lisview);

        //2. Data Source
        dataModel=new ArrayList<>();

        dataModel.add(new CountryModelClass("India","3",R.drawable.india));
        dataModel.add(new CountryModelClass("Germany","3",R.drawable.germany));
        dataModel.add(new CountryModelClass("Norway","2",R.drawable.norway));
        dataModel.add(new CountryModelClass("Switzerland","1",R.drawable.switzerland));
        dataModel.add(new CountryModelClass("England","1",R.drawable.england));

        //3. Adapter
        adapter=new CustomAdapter(dataModel,getApplicationContext());
        listView.setAdapter((adapter));

        //4. Handling the click events on ListView item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Country :- "+adapter.getItem(i).getCountry_name()+
                        "\n World Cups - "+ adapter.getItem(i).getCup_win_count(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}