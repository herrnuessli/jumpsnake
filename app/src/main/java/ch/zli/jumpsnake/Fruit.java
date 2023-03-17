package ch.zli.jumpsnake;

import android.graphics.Rect;

import java.util.Random;

public class Fruit {
    private int x, y;
    private Random random;

    public Fruit() {
        random = new Random();
        x = 0;
        y = 0;
    }

    public void init(int width, int height) {
        x = random.nextInt(width - 200) + 100;
        y = random.nextInt(height - 200) + 100;
    }

    public boolean checkCollision(Rect rect) {
        return rect.contains(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
