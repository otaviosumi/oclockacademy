package com.example.sumi.schoolwar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.sumi.schoolwar.datastructures.UserProfile;
import com.example.sumi.schoolwar.overflowmenu.UserAboutActivity;
import com.example.sumi.schoolwar.overflowmenu.UserItemActivity;
import com.example.sumi.schoolwar.overflowmenu.UserProfileActivity;
import com.example.sumi.schoolwar.overflowmenu.UserSocialActivity;

public class MainMenu extends AppCompatActivity {

    ImageView rotateImage, rotateImage2, btnImg;
    private boolean canClose;
    public static UserProfile user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }



    public void new_game_selected(View view) {
        cross_selected(view, R.id.cross_new_game_btn);
    }

    public void exit_game_selected(View view) {
        cross_selected(view, R.id.cross_exit_game_btn);
     }
    public void cross_selected(View view, final int fieldID){
        btnImg = (ImageView) findViewById(fieldID);
        Animation btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selected_item);
        btnImg.setImageResource(R.drawable.ic_camera_black_24dp);
        btnImg.startAnimation(btnAnim);
        btnAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btnImg.setImageResource(0);
                if(fieldID == R.id.cross_exit_game_btn){
                    System.exit(1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.profile_menu:
                intent = new Intent(this, UserProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.items_menu:
                intent = new Intent(this, UserItemActivity.class);
                startActivity(intent);
                return true;
            case R.id.social_menu:
                intent = new Intent(this, UserSocialActivity.class);
                startActivity(intent);
                return true;
            case R.id.main_menu:
                intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                return true;
            case R.id.about_menu:
                intent = new Intent(this, UserAboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
