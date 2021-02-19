package com.company;

import java.util.*;

public class Router {
    ArrayList<Device> connections;
    semaphore sem;

    public Router(int maxConnections) {
        connections = new ArrayList<>();
        for (int i = 0; i < maxConnections; i++) {
            connections.add(null);
        }
        sem = new semaphore(maxConnections);
    }

    public synchronized int connect(Device device) {
        sem.acquire(device);
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i) == null) {
                connections.set(i, device);
                return i + 1;
            }
        }
        return -1;
    }

    public void disconnect(Device device) {
        int idx = connections.indexOf(device);
        connections.set(idx, null);
        sem.release(device, idx + 1);
    }
}
