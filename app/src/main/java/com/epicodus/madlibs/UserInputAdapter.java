package com.epicodus.madlibs;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserInputAdapter extends ArrayAdapter<String> {
    HashMap<Integer, String> positionsValues = new HashMap<Integer, String>();

    public UserInputAdapter(Context context, ArrayList<String> inputs) {
        super(context, 0, inputs);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
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

        String oldText = positionsValues.get(position);
        if (oldText != null) {
            Log.d("old", position + "");
            Log.d("old", oldText);
        }

        if (oldText == null) {
            etInput.setText("");
        } else {
            etInput.setText(oldText);
        }

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                positionsValues.put(position, s.toString());
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
