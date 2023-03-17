package ch.zli.jumpsnake;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
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
=======
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
>>>>>>> 95653d6 (finish snake prototype)

import java.util.concurrent.atomic.AtomicInteger;

public class GameActivity extends AppCompatActivity {

<<<<<<< HEAD
>>>>>>> 7c1d5a1 (add activities)
=======
    private static final int FPS = 60;
    private static final int SPEED = 25;

    private static final int STATUS_PAUSED = 1;
    private static final int STATUS_START = 2;
    private static final int STATUS_OVER = 3;
    private static final int STATUS_PLAYING = 4;

    private GameView mGameView;
    private TextView mGameStatusText;
    private TextView mGameScoreText;
    private Button mGameBtn;

    private final AtomicInteger mGameStatus = new AtomicInteger(STATUS_START);

    private final Handler mHandler = new Handler();

>>>>>>> 95653d6 (finish snake prototype)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);
<<<<<<< HEAD
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
=======

        mGameView = findViewById(R.id.game_view);
        mGameStatusText = findViewById(R.id.game_status);
        mGameBtn = findViewById(R.id.game_control_btn);
        mGameScoreText = findViewById(R.id.game_score);
        mGameView.init();
        mGameView.setGameScoreUpdatedListener(score -> {
            mHandler.post(() -> mGameScoreText.setText("Score: " + score));
        });

        findViewById(R.id.up_btn).setOnClickListener(v -> {
            if (mGameStatus.get() == STATUS_PLAYING) {
                mGameView.setDirection(Direction.UP);
            }
        });
        findViewById(R.id.down_btn).setOnClickListener(v -> {
            if (mGameStatus.get() == STATUS_PLAYING) {
                mGameView.setDirection(Direction.DOWN);
            }
        });
        findViewById(R.id.left_btn).setOnClickListener(v -> {
            if (mGameStatus.get() == STATUS_PLAYING) {
                mGameView.setDirection(Direction.LEFT);
            }
        });
        findViewById(R.id.right_btn).setOnClickListener(v -> {
            if (mGameStatus.get() == STATUS_PLAYING) {
                mGameView.setDirection(Direction.RIGHT);
            }
        });

        mGameBtn.setOnClickListener(v -> {
            if (mGameStatus.get() == STATUS_PLAYING) {
                setGameStatus(STATUS_PAUSED);
            } else {
                setGameStatus(STATUS_PLAYING);
            }
        });

        setGameStatus(STATUS_START);
>>>>>>> 95653d6 (finish snake prototype)
    }

    @Override
    protected void onPause() {
        super.onPause();
<<<<<<< HEAD
        snakeView.stopGame();
    }
=======
>>>>>>> 7c1d5a1 (add activities)
=======
        if (mGameStatus.get() == STATUS_PLAYING) {
            setGameStatus(STATUS_PAUSED);
        }
    }

    private void setGameStatus(int gameStatus) {
        int prevStatus = mGameStatus.get();
        mGameStatusText.setVisibility(View.VISIBLE);
        mGameBtn.setText("start");
        mGameStatus.set(gameStatus);
        switch (gameStatus) {
            case STATUS_OVER:
                mGameStatusText.setText("GAME OVER");
                break;
            case STATUS_START:
                mGameView.newGame();
                mGameStatusText.setText("START GAME");
                break;
            case STATUS_PAUSED:
                mGameStatusText.setText("GAME PAUSED");
                break;
            case STATUS_PLAYING:
                if (prevStatus == STATUS_OVER) {
                    mGameView.newGame();
                }
                startGame();
                mGameStatusText.setVisibility(View.INVISIBLE);
                mGameBtn.setText("pause");
                break;
        }
    }

    private void startGame() {
        final int delay = 1000 / FPS;
        new Thread(() -> {
            int count = 0;
            while (!mGameView.isGameOver() && mGameStatus.get() != STATUS_PAUSED) {
                try {
                    Thread.sleep(delay);
                    if (count % SPEED == 0) {
                        mGameView.next();
                        mHandler.post(mGameView::invalidate);
                    }
                    count++;
                } catch (InterruptedException ignored) {
                }
            }
            if (mGameView.isGameOver()) {
                mHandler.post(() -> setGameStatus(STATUS_OVER));
            }
        }).start();
    }
>>>>>>> 95653d6 (finish snake prototype)
}