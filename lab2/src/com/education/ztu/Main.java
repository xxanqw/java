package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla");
        Car.Engine engine = car.new Engine();

        Student student = new Student("Ivan", "Potiienko", 20, Location.TOWN, Gender.MALE, "Zhytomyrska Politehnica University");
        Teacher teacher = new Teacher("Will", "Smith", 45, Location.CITY, Gender.FEMALE, "Music", car);
        Employee employee = new Employee("Lil", "Peep", 30, Location.VILLAGE, Gender.FEMALE, "Owner", car);

        student.sayFullName();
        System.out.println(student.getFullInfo());

        teacher.sayFullName();
        System.out.println(teacher.getFullInfo());

        employee.sayFullName();
        System.out.println(employee.getFullInfo());

        engine.startEngine();
        System.out.println("Engine works: " + engine.isEngineWorks());
        engine.stopEngine();

        Person.showCounter();

        System.out.println(teacher instanceof Person);
    }
}