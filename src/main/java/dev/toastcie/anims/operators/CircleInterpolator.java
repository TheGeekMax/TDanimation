package dev.toastcie.anims.operators;

import dev.toastcie.anims.shapes.Circle;

import java.io.Serializable;

public class CircleInterpolator extends Interpolator<Circle> implements Serializable {
    int test = 0;

    public CircleInterpolator() {
        super();
    }

    @Override
    public boolean hasNext() {
        return currentTick <= duration;
    }

    private int lerp(int a, int b, int t) {
        return a + (b - a) * t / duration;
    }

    @Override
    public Circle next() {
        if (currentTick > duration) {
            return end;
        }

        Circle c = new Circle();
        c.setX(lerp(start.getX(), end.getX(), currentTick));
        c.setY(lerp(start.getY(), end.getY(), currentTick));
        c.setRadius(lerp(start.getRadius(), end.getRadius(), currentTick));
        currentTick++;
        return c;
    }
}
