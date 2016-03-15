package com.epicodus.madlibs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class UserInputAdapter extends ArrayAdapter<String> {
    public UserInputAdapter(Context context, ArrayList<String> inputs) {
        super(context, 0, inputs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String input = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_inputs, parent, false);
        }
        // Lookup view for data population
        EditText etInput = (EditText) convertView.findViewById(R.id.user_input);
        // Populate the data into the template view using the data object
        etInput.setHint(input);
        // Return the completed view to render on screen
        return convertView;
    }
}
