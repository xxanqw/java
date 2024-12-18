package com.education.ztu;

import com.education.ztu.game.Participant;
import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Schoolar("Nick", 13));
        participants.add(new Schoolar("Alice", 15));
        participants.add(new Student("John", 20));
        participants.add(new Student("Amy", 19));

        participants.sort(Comparator.comparing(Participant::getName));
        System.out.println("Participants sorted by name:");
        participants.forEach(System.out::println);

        participants.sort(Comparator.comparingInt(Participant::getAge));
        System.out.println("\nParticipants sorted by age:");
        participants.forEach(System.out::println);

        participants.sort(Comparator.comparing(Participant::getName).thenComparingInt(Participant::getAge));
        System.out.println("\nParticipants sorted by name and then age:");
        participants.forEach(System.out::println);
    }
}
