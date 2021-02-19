package com.company;

import java.util.ArrayList;

class semaphore {
    protected int value = 0;

    protected semaphore(int initial) {
        value = initial;
    }

    public synchronized void acquire(Device device) {
        value--;
        if (value < 0) {
            try {
                System.out.println("(" + device.getName() + ") (" + device.getType() + ") arrived and waiting");
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("(" + device.getName() + ") " + "(" + device.getType() + ") connected");
    }

    public synchronized void release(Device device, int connection) {
        System.out.println("Connection " + connection + ": (" + device.getName() + ") " +
                "(" + device.getType() + ") has logged out");
        value++;
        if (value <= 0) notify();
    }

    public synchronized int getValue() {
        return value;
    }
}
