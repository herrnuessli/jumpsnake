package ch.zli.jumpsnake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Hide the navigation bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Button easyButton = findViewById(R.id.easy);
        Button normalButton = findViewById(R.id.normal);
        Button hardButton = findViewById(R.id.hard);

        Intent intent = new Intent(MainActivity.this, GameActivity.class);

        easyButton.setOnClickListener(view -> {
            int difficulty = 0;
            intent.putExtra("difficulty", difficulty);
            startActivity(intent);
        });
        normalButton.setOnClickListener(view -> {
            int difficulty = 1;
            intent.putExtra("difficulty", difficulty);
            startActivity(intent);
        });
        hardButton.setOnClickListener(view -> {
            int difficulty = 2;
            intent.putExtra("difficulty", difficulty);
            startActivity(intent);
        });


    }
}