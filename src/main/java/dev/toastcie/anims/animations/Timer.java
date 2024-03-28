package dev.toastcie.anims.animations;

import java.util.ArrayList;

public class Timer {
    //variables to send
    private int time = 0;

    //variable for this object
    private int period = 1000;

    private ArrayList<TickListener> events = new ArrayList<>();

    public void setPeriod(int period) {
        this.period = period;
    }


    public void addTickListener(TickListener t) {
        events.add(t);
    }

    public void run() {
        while (true) {
            for (TickListener e : events) {
                e.tick(new TickEvent(time));
            }

            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time += period;
        }
    }

    public void start() {
        while (true) {
            for (TickListener e : events) {
                e.tick(new TickEvent(time));
            }

            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time += period;
        }
    }
}