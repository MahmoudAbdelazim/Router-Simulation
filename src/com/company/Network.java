package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is number of WI-FI Connections? ");
        int numConnections = in.nextInt();
        Router router = new Router(numConnections);

        System.out.println("What is number of devices Clients want to connect? ");
        int numDevices = in.nextInt();
        ArrayList<Thread> devices = new ArrayList<>();

        for (int i = 0; i < numDevices; i++) {
            String name, type;
            name = in.next();
            type = in.next();
            devices.add(new Thread(new Device(name, type, router)));
        }

        for (int i = 0; i < numDevices; i++) {
            devices.get(i).start();
        }
    }
}
