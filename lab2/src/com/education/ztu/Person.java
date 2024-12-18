package com.education.ztu;

public abstract class Person implements Human {
    private String firstName;
    private String lastName;
    private int age;
    private Location location;
    private Gender gender;
    private static int counter;
    private static String defaultInfo = "N/A";

    {
        firstName = defaultInfo;
        lastName = defaultInfo;
        age = 0;
        location = Location.TOWN;
        gender = Gender.OTHER;

        counter++;
    }

    public Person() {}

    public Person(String firstName, String lastName, int age, Location location, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public abstract String getOccupation();

    public String getFullInfo() {
        return getOccupation() + ": " + firstName + " " + lastName + ", " + age + " years old, "
                + gender + ", from " + location;
    }

    public static void showCounter() {
        System.out.println("Persons created: " + counter);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void sayFullName() {
        System.out.println(firstName + " " + lastName);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }
}