package ch.zli.jumpsnake;

import android.graphics.Rect;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Rect> segments;
    private int dx;
    private int dy;

    public Snake() {
        segments = new ArrayList<>();
        segments.add(new Rect(0, 0, 100, 100));
        dx = 10;
        dy = 0;
    }

    public void init(int width, int height) {
        segments.clear();
        segments.add(new Rect(width/2, height/2, width/2 + 100, height/2 + 100));
        dx = 10;
        dy = 0;
    }

    public int getSize() {
        return segments.size();
    }

    public Rect getSegment(int index) {
        return segments.get(index);
    }

    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        // Move the segments of the snake
        for (int i = segments.size() - 1; i > 0; i--) {
            Rect current = segments.get(i);
            Rect previous = segments.get(i - 1);
            current.set(previous);
        }

        // Move the head of the snake in the specified direction
        Rect head = segments.get(0);
        head.offset(dx, dy);
    }

    public void grow() {
        // Get the last segment of the snake
        Rect lastSegment = segments.get(segments.size() - 1);

        // Add a new segment to the snake in the same position as the last segment
        Rect newSegment = new Rect(lastSegment);
        segments.add(newSegment);
    }

    public boolean checkCollision(int x, int y) {
        Rect head = getSegment(0);
        return (x >= head.left && x < head.right && y >= head.top && y < head.bottom);
    }

}
