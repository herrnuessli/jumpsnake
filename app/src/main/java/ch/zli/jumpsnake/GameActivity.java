package ch.zli.jumpsnake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private SnakeView snakeView;
    private Button buttonUp, buttonDown, buttonLeft, buttonRight;

=======

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

>>>>>>> 7c1d5a1 (add activities)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);
<<<<<<< HEAD

        // Set content view to SnakeView
        snakeView = new SnakeView(this, null);
        buttonUp = findViewById(R.id.buttonUp);
        buttonDown = findViewById(R.id.buttonDown);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonRight = findViewById(R.id.buttonRight);
        setContentView(snakeView);

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.moveUp();
            }
        });

        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.moveDown();
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.moveLeft();
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.moveRight();
            }
        });

        //difficulty
        Intent intent = getIntent();
        int difficulty = intent.getIntExtra("difficulty",0);

    }
    @Override
    protected void onResume() {
        super.onResume();
        snakeView.startGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        snakeView.stopGame();
    }
=======
>>>>>>> 7c1d5a1 (add activities)
}