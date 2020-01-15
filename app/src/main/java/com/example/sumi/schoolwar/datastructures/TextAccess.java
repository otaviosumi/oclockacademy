package com.example.sumi.schoolwar.datastructures;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class TextAccess {

    private Context myContext;
    private JSONArray jsonArray;

    public TextAccess(Context myContext) {
        this.myContext = myContext;
    }

    public void get_json(){
        String json = null;
        try {
            InputStream is = myContext.getAssets().open("history_text.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            jsonArray = new JSONArray(json);

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public JSONObject get_json_obj(int index){
        get_json();
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
