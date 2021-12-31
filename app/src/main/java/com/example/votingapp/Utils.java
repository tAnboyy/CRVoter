package com.example.votingapp;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Candidate> candidateList = new ArrayList<>();

    public static void updateCandidate(String prevName, String newName, String promise, String ig) {
        for (Candidate c : candidateList) {
            if (c.name.equalsIgnoreCase(prevName)) {
                c.name = newName;
                if (!promise.equalsIgnoreCase(c.tagline)) {
                    c.tagline = promise;
                }
                if (!promise.equalsIgnoreCase(c.ig)) {
                    c.ig = ig;
                }
            }
        }
    }

    public static void resetVoteCount() {
        for (Candidate c : candidateList) {
            c.voteCount = 0;
        }
    }

    public static String getWinner() {
        String winner = "";
        int count = Integer.MIN_VALUE;
        for (Candidate c : candidateList) {
            if (c.voteCount > count) {
                count = c.voteCount;
                winner = c.name;
            }
        }
        if (count == 0) {
            return "";
        }
        return winner;
    }
}
