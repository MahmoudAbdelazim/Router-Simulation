package com.company;

public class Device implements Runnable {

    private String name;
    private String type;
    private Router router;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    @Override
    public void run() {
        try {
            int connection = router.connect(this);
            Thread.sleep(100);
            System.out.println("Connection " + connection + ": (" + name + ") (" + type + ") performs online activity");
            Thread.sleep(100);
            router.disconnect(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
