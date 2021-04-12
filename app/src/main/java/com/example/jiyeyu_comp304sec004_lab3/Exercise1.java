package com.example.jiyeyu_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Exercise1 extends AppCompatActivity {

    private ImageView reusableImageView;
    private TextView textView;
    //
    //vertical
    private int startx = 250;
    private int starty = 15;
    private int endx = 250;
    private int endy = 300;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    private RadioGroup radioGroup;


    //
    //Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);


        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        //paint.setStrokeMiter((float)0.5);

        //default thickness of lines
        paint.setStrokeWidth(30);

        //creating a bitmap as content view for the image

        //resize cavas
        bitmap = Bitmap.createBitmap(1650,2000, Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);

        //set the background for your drawings

        //I changed
        canvas.drawColor(Color.WHITE); //background

        //setup the image view
        reusableImageView = (ImageView) findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.txPosition);
        textView.setText(getResources().getString(R.string.clear));

        //
        //reusableImageView.setImageResource(R.drawable.green_rect);


        // declare thickness and color
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);


        //

        Spinner spinner = findViewById(R.id.spinner);

//
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                // your code here
                switch (position) {


                    case 0: // for item 1
                        //not changed
                        spinner.setSelection(0,false);
                        break;

                    case 1:
                        paint.setStrokeWidth(10);
                        break;

                    case 2:
                        paint.setStrokeWidth(20);
                        break;
                    case 3:
                        paint.setStrokeWidth(30);
                        break;
                    case 4:
                        paint.setStrokeWidth(40);
                        break;

                    case 5:
                        paint.setStrokeWidth(50);
                        break;

                    case 6:
                        paint.setStrokeWidth(60);
                        break;

                    case 7:
                        paint.setStrokeWidth(70);
                        break;

                    case 8:
                        paint.setStrokeWidth(80);
                        break;

                    case 9:
                        paint.setStrokeWidth(90);
                        break;

                    case 10:
                        paint.setStrokeWidth(100);
                        break;

                    default:
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


    }// end of onCreate


    //Toggle

    public void onToggleClicked (View v){
        boolean on = ((ToggleButton) v).isChecked();

        //Off text is Start because it is the default off state when you turn on the app
        //When pressed, the function operates as start
        if(on){
            canvas.drawPoint(250, 15, paint);
        }
        else{
            canvas.drawColor(Color.WHITE);
            startx = 250;
            starty = 15;
            endx = 250;
            endy = 300;
            textView.setText(getResources().getString(R.string.clear));


        }
    }



    public void drawLine(Canvas canvas) {
//
// y= 110;
        textView.setText(String.valueOf("  y=  "+ endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;

    }

    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //declare togglebutton for changing the status
        ToggleButton toggleButton = findViewById(R.id.ButtonToggle);

        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy = endy + 5;
                drawLine(canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                //if users press the keyboard without clicking Start button, it switches to On automatically.

                toggleButton.setChecked(true);

                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx = endx + 5;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                toggleButton.setChecked(true);

                return true;


            //I add
            case KeyEvent.KEYCODE_DPAD_UP:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy = endy - 5;
                drawLine(canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                toggleButton.setChecked(true);
                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx = endx - 5;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                toggleButton.setChecked(true);
                return true;
        }
        //enable Back key
        return super.onKeyDown(keyCode, event);
    }


    // Arrow keys click event

    public void ArrowDown(View view) {
        endy = endy + 5;
        drawLine(canvas);

        //same as keyboard condition if press it without Start button
        ToggleButton toggleButton = findViewById(R.id.ButtonToggle);
        toggleButton.setChecked(true);

    }

    public void ArrowRight(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx = endx + 5;
        drawLine(canvas);
        //moveRect(canvas);
        reusableImageView.invalidate();

        ToggleButton toggleButton = findViewById(R.id.ButtonToggle);
        toggleButton.setChecked(true);

    }

    public void ArrowUp(View view) {
        endy = endy - 5;
        drawLine(canvas);

        ToggleButton toggleButton = findViewById(R.id.ButtonToggle);
        toggleButton.setChecked(true);

    }

    public void ArrowLeft(View view) {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx = endx - 5;
        drawLine(canvas);
        //moveRect(canvas);
        reusableImageView.invalidate();

        ToggleButton toggleButton = findViewById(R.id.ButtonToggle);
        toggleButton.setChecked(true);


    }



    //Line Color

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.btnRed) {
                paint.setColor(Color.RED);

            } else if (i == R.id.btnYellow) {
                paint.setColor(Color.YELLOW);

            } else if (i == R.id.btnCyan) {

                paint.setColor(Color.CYAN);
            }
        }
    };

}
