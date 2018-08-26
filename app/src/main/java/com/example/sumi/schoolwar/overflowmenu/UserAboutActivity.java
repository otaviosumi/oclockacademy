package com.example.sumi.schoolwar.overflowmenu;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.sumi.schoolwar.MainMenu;
import com.example.sumi.schoolwar.R;
import com.example.sumi.schoolwar.datastructures.UserProfile;

public class UserAboutActivity extends AppCompatActivity {

    ImageView rotateImage, rotateImage2, btnImg;
    UserProfile user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_about);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.user_about_atv));
        //Animations-------------------------------------------------
        rotateImage = (ImageView) findViewById(R.id.rotating_image);
        rotateImage2 = (ImageView) findViewById(R.id.rotating_image2);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_botton_left);
        Animation startRotateAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_upper_right);
        rotateImage.startAnimation(startRotateAnimation);
        rotateImage2.startAnimation(startRotateAnimation2);
        //-----------------------------------------------------------

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
