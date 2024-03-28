package dev.toastcie.anims.operators;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Interpolator<T> implements Iterator<T>, Serializable {
    protected T start;
    protected T end;
    protected int duration;
    protected int currentTick = 0;

    public Interpolator() {

    }

    public Interpolator(T start, T end, int duration) {
        this.start = start;
        this.end = end;
        this.duration = duration;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
