package com.epicodus.madlibs;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] inputs = res.getStringArray(R.array.story_inputs_1);
        ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(inputs));

        ListView listView = (ListView) findViewById(R.id.listView);
        UserInputAdapter adapter = new UserInputAdapter(this, inputArrayList);
        listView.setAdapter(adapter);

    }
}
