package com.example.jiyeyu_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);


        // Handle Grow Button
        final Button growButton = (Button) findViewById(R.id.ButtonScale);
        growButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.grow);
            }
        });

        // Handle Move Button
        final Button moveButton = (Button) findViewById(R.id.ButtonTranslate);
        moveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.translate_position);
            }
        });

        // Handle Spin Button
        final Button spinButton = (Button) findViewById(R.id.ButtonRotate);
        spinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.spin);
            }
        });

        // Handle All Button
        final Button allButton = (Button) findViewById(R.id.ButtonAll);
        allButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.all);
            }
        });

        // Handle Stop Button
        final Button stopButton = (Button) findViewById(R.id.ButtonStop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.stop);
            }
        });

    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.moon);
        //reusableImageView.setImageResource(R.drawable.green_rect);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private void toggleButtons(boolean clickableState)
    {


        // Handle Grow Button
        final Button growButton = (Button) findViewById(R.id.ButtonScale);
        growButton.setClickable(clickableState);

        // Handle Move Button
        final Button moveButton = (Button) findViewById(R.id.ButtonTranslate);
        moveButton.setClickable(clickableState);

        // Handle Spin Button
        final Button spinButton = (Button) findViewById(R.id.ButtonRotate);
        spinButton.setClickable(clickableState);

        // Handle Spin Button
        final Button allButton = (Button) findViewById(R.id.ButtonAll);
        allButton.setClickable(clickableState);

        // Handle Spin Button
        final Button stopButton = (Button) findViewById(R.id.ButtonStop);
        stopButton.setClickable(clickableState);
    }

    class MyAnimationListener implements Animation.AnimationListener {


        //no hide
        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView)findViewById(R.id.moon);
//            reusableImageView.setVisibility(View.INVISIBLE);

            // Enable all buttons once animation is over
            toggleButtons(true);

        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running

            //able to click any buttons while animation is running
            toggleButtons(true);

        }

    }

}