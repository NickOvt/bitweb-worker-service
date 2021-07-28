package com.api.worker.dao;

import com.api.worker.models.Choice;

import java.util.UUID;

public interface ChoiceDao {
    void insertChoice(UUID id, Choice choice);

    default void insertChoice(Choice choice) {
        UUID id = UUID.randomUUID();
        insertChoice(id, choice);
    }
}
