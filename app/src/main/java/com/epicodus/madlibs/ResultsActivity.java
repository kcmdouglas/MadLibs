package com.epicodus.madlibs;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    private static final String TAG = ResultsActivity.class.getSimpleName();
    private String thisStory;
    private Button mTryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Resources resources = getResources();
        Intent intent = getIntent();

        ArrayList<String> userInputs = intent.getStringArrayListExtra("userInputs");
        String[] inputArray = new String[userInputs.size()];
        inputArray = userInputs.toArray(inputArray);

        thisStory = resources.getString(R.string.story_1);

        String formattedStory = String.format(thisStory, (Object[])inputArray);

        TextView storyArea = (TextView) findViewById(R.id.storyArea);
        try {
            storyArea.setText(formattedStory);
        } catch (NullPointerException npe) {
            Log.e(TAG, "Failure in story formatting: " + npe.getMessage());
        }

        mTryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        mTryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
