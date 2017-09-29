package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.

        /*
        //Used setImageDrawable() method
        String image = "@drawable/after_cookie";
        int imageResource = getResources().getIdentifier(image, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);

        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageDrawable(res);
        */

        //Used setImageResource() method
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        //Performs what "R.drawable.[name]" does:
        // int id = getResources().getIdentifier("after_cookie","drawable",getPackageName());
        imageView.setImageResource(R.drawable.after_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView status = (TextView) findViewById(R.id.status_text_view);
        status.setText("I'm so full");
    }
}