package com.example.sumi.schoolwar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import org.json.JSONException;

public class Storyteller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyteller);
        TextView main_text = findViewById(R.id.main_text);
        try {
            main_text.setText(MainMenu.textAccess.get_json_obj(MainMenu.textIndex).getString("m_text"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
