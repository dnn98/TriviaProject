package com.example.triviaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //begin list
        ListView menuList = (ListView) findViewById(R.id.lista);
        String[] items = { getResources().getString(R.string.menu_item_play), getResources().getString(R.string.menu_item_scores), getResources().getString(R.string.menu_item_settings), getResources().getString(R.string.menu_item_help) };
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,R.layout.menu_item, items);
        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            public void onItemClick(AdapterView<?> parent, View itemClicked,
                                                                    int position, long id) {
                                                TextView textView = (TextView) itemClicked;
                                                String strText = textView.getText().toString();
                                                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_play))) {
                                                    // Launch the Game Activity
                                                    startActivity(new Intent(MainActivity.this, test.class));
                                                }
                                                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))) {
                                                    startActivity(new Intent(MainActivity.this, test.class));
                                                }
                                                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))) {
                                                    startActivity(new Intent(MainActivity.this, test.class));
                                                }
                                                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_scores))) {
                                                    startActivity(new Intent(MainActivity.this, test.class));
                                                }
                                            }
                                        });
        //end list

        TextView hello = findViewById(R.id.hello);
        //loading prefs
        SharedPreferences prefs = getSharedPreferences("last_launch", MODE_PRIVATE);
        String name = prefs.getString("dateTime", "No name defined");//"No name defined" is the default value.
        hello.setText("Last launch: "+name);

        SharedPreferences lastTime = getSharedPreferences("last_launch", MODE_PRIVATE);
        Date now = new Date();

        SimpleDateFormat format = new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");

        Log.i(TAG, "In MainActivity");

        if (lastTime.contains("dateTime") == true) {
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "In MainActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();

        dateEditor.putString("dateTime",format.format(now));
        dateEditor.apply();
        dateEditor.commit();
    }




}