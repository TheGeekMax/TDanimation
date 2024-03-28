package dev.toastcie.anims.shapes;

import java.io.Serializable;

public class Circle implements Serializable {
    private int x;
    private int y;

    private int radius;

    public Circle() {
        

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle add(Circle other) {
        Circle c = new Circle();
        c.setX(this.x + other.x);
        c.setY(this.y + other.y);
        c.setRadius(this.radius + other.radius);
        return c;
    }

    public Circle sub(Circle other) {
        Circle c = new Circle();
        c.setX(this.x - other.x);
        c.setY(this.y - other.y);
        c.setRadius(this.radius - other.radius);
        return c;
    }

    public Circle mult(int scalar) {
        Circle c = new Circle();
        c.setX(this.x * scalar);
        c.setY(this.y * scalar);
        c.setRadius(this.radius * scalar);
        return c;
    }

    public Circle div(int scalar) {
        Circle c = new Circle();
        c.setX(this.x / scalar);
        c.setY(this.y / scalar);
        c.setRadius(this.radius / scalar);
        return c;
    }

    public String toString() {
        return "Circle(" + x + ", " + y + ", " + radius + ")";
    }
}
