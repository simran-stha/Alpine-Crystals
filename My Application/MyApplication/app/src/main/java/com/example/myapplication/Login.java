package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List<Crystals> image_details = getListData();
                final ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(new CustomListAdapter(this, image_details));

                // When the user clicks on the ListItem
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Object o = listView.getItemAtPosition(position);
                        Crystals crystals = (Crystals) o;
                        Context context = getApplicationContext();
                        Toast.makeText(context,
                                "Selected :" + " " + crystals,
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            private  List<Crystals> getListData() {
                List<Crystals> list = new ArrayList<Crystals>();
                Crystals clearQuartz = new Crystals("Clear Quartz", "clearquartz", "April");
                Crystals amethyst = new Crystals("Amethyst", "amethyst", "February");
                Crystals moonstone = new Crystals("Moonstone", "moonstone", "June");




                list.add(clearQuartz);
                list.add(amethyst);
                list.add(moonstone);

                return list;
            }



}