package com.example.sumi.schoolwar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sumi.schoolwar.datastructures.TextAccess;
import com.example.sumi.schoolwar.datastructures.UserProfile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainMenu extends AppCompatActivity {

    ImageView rotateImage, rotateImage2, btnImg;
    private boolean canClose;
    public static UserProfile user;
    public static TextAccess textAccess;
    public static int textIndex;
    public static JSONArray hist_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        textAccess = new TextAccess(getApplicationContext());
        textIndex = 0;
        setup_json();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Animations-------------------------------------------------
        rotateImage = (ImageView) findViewById(R.id.rotating_image);
        rotateImage2 = (ImageView) findViewById(R.id.rotating_image2);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_botton_left);
        Animation startRotateAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_upper_right);
        rotateImage.startAnimation(startRotateAnimation);
        rotateImage2.startAnimation(startRotateAnimation2);
        //-----------------------------------------------------------
        canClose = false;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        //Loading Profile Info---------------------------------------
        user = new UserProfile();
        //-----------------------------------------------------------
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    private void setup_json() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("history_text.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            hist_txt = new JSONArray(json);
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//    }

    @Override
    public void onBackPressed() {
        //moveTaskToBack(true);
    }


    //Call for start game
    public void new_game_selected(View view) {
        if(findViewById( R.id.cross_new_game_btn).isEnabled()) {
            cross_selected(view, R.id.cross_new_game_btn);
        }
    }

    //Exit the game
    public void exit_game_selected(View view) {
        if(findViewById(R.id.cross_exit_game_btn).isEnabled()) {
            cross_selected(view, R.id.cross_exit_game_btn);
        }
     }

    //Make decision to start or exit the game
    public void cross_selected(View view, final int fieldID){
        btnImg = (ImageView) findViewById(fieldID);
        Animation btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selected_item);
        btnImg.setImageResource(R.drawable.ic_camera_black_24dp);
        btnImg.startAnimation(btnAnim);
        btnAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                findViewById(R.id.cross_new_game_btn).setEnabled(false);
                //findViewById(R.id.cross_exit_game_btn).setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btnImg.setImageResource(0);
                if(fieldID == R.id.cross_new_game_btn){
                    Toast toast = Toast.makeText(getApplicationContext(), "Lendo arquivos...", Toast.LENGTH_LONG);
                    toast.show();
                    Intent i = new Intent(getApplicationContext(), Storyteller.class);
                    startActivity(i);
                }else if(fieldID == R.id.cross_exit_game_btn){
                    System.exit(1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
