package com.education.ztu.game;

public class Game {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Nick", 13);
        Schoolar schoolar2 = new Schoolar("Elena", 12);

        Student student1 = new Student("John", 20);
        Student student2 = new Student("Alice", 18);

        Employee employee1 = new Employee("Robert", 29);
        Employee employee2 = new Employee("Sophia", 32);

        Team<Schoolar> schoolarTeam = new Team<>("Dragon");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Workers");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolarTeam.playWith(schoolarTeam);
        studentTeam.playWith(studentTeam);
    }
}
