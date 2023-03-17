package ch.zli.jumpsnake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SnakeView extends View implements Runnable {
    private Snake snake;
    private Fruit fruit;
    private Paint paint;
    private boolean running;
    private Thread gameThread;

    public SnakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        snake = new Snake();
        fruit = new Fruit();
        paint = new Paint();
        paint.setAntiAlias(true);
        running = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);

        // Draw the snake
        for (int i = 0; i < snake.getSize(); i++) {
            Rect segment = snake.getSegment(i);
            canvas.drawRect(segment, paint);
        }

        // Draw the fruit
        paint.setColor(Color.RED);
        canvas.drawCircle(fruit.getX() + 50, fruit.getY() + 50, 50, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        snake.init(w, h);
        fruit.init(w, h);
    }

    public void moveLeft() {
        snake.setDirection(-10, 0);
    }

    public void moveRight() {
        snake.setDirection(10, 0);
    }

    public void moveUp() {
        snake.setDirection(0, -10);
    }

    public void moveDown() {
        snake.setDirection(0, 10);
    }

    public void startGame() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pauseGame() {
        running = false;
    }

    public void resumeGame() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void update() {
        snake.move();

        // Check for collision with fruit
        if (fruit.checkCollision(snake.getSegment(0))) {
            fruit.init(getWidth(), getHeight());
            snake.grow();
        }

        // Check for collision with walls or self
        if (snake.checkCollision(getWidth(), getHeight())) {
            stopGame();
        }
    }

    @Override
    public void run() {
        while (running) {
            update();
            postInvalidate();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
