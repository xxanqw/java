package com.education.ztu;

public class Employee extends Person {
    private String jobTitle;
    private Car car;

    public Employee(String firstName, String lastName, int age, Location location, Gender gender, String jobTitle, Car car) {
        super(firstName, lastName, age, location, gender);
        this.jobTitle = jobTitle;
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "Employee";
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}