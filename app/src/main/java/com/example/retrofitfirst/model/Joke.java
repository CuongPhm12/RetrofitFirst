package com.example.retrofitfirst.model;

import com.google.gson.annotations.SerializedName;

public class Joke {
    private String type;
    private String setup;
    @SerializedName("punchline")
    private String punchLine;
    private int id;


    public Joke(String type, String setup, String punchLine, int id) {
        this.type = type;
        this.setup = setup;
        this.punchLine = punchLine;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(String punchLine) {
        this.punchLine = punchLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
