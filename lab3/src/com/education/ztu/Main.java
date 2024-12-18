package com.education.ztu;

import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Student;
import com.education.ztu.game.Team;

public class Main {
    public static void main(String[] args) {
        Schoolar participant1 = new Schoolar("John Doe", 13);
        Student participant2 = new Student("Jane Doe", 20);

        System.out.println("Participant 1: " + participant1);
        System.out.println("Participant 2: " + participant2);

        Team<Schoolar> schoolarTeam = new Team<>("Team A");
        schoolarTeam.addNewParticipant(participant1);

        Team<Student> studentTeam = new Team<>("Team B");
        studentTeam.addNewParticipant(participant2);
        
        schoolarTeam.playWith(new Team<>("Opposition Team A"));
        studentTeam.playWith(new Team<>("Opposition Team B"));
    }
}