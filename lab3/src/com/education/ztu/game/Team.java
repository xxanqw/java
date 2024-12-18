package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public void playWith(Team<T> team) {
        int thisTeamScore = this.participants.size();
        int otherTeamScore = team.participants.size();

        String winnerName = thisTeamScore >= otherTeamScore ? this.name : team.name;
        System.out.println("The team " + winnerName + " is winner!");
    }
}
