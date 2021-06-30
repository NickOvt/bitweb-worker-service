package com.api.worker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Choice {
    @NotBlank
    private String choice;

    public Choice(@JsonProperty("choice") String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
