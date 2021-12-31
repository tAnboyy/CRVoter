package com.example.votingapp;

public class Candidate {
    public String name;
    public int voteCount;
    public String tagline;
    public String ig;

    public Candidate(String name, int voteCount, String promise, String ig) {
        this.name = name; this.voteCount = voteCount; this.tagline = promise; this.ig = ig;
    }
}
