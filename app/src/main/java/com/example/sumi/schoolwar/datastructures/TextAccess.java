package com.example.sumi.schoolwar.datastructures;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class TextAccess {

    private Context myContext;

    public TextAccess(Context myContext) {
        this.myContext = myContext;
    }

    public void get_json(){
        String json;
        try {
            InputStream is = myContext.getAssets().open("history_text.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
//                textlist.add(obj)
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
