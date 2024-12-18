package com.education.ztu;

public class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public class Engine {
        private boolean running;

        public void startEngine() {
            running = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            running = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return running;
        }
    }
}
