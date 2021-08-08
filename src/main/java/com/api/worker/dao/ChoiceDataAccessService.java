package com.api.worker.dao;

import com.api.worker.models.Choice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ChoiceDataAccessService implements ChoiceDao{
    private final JdbcTemplate jdbcTemplate;

    public ChoiceDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertChoice(UUID id, Choice choice) {
        final String query = "INSERT INTO choice (id, choice_value) VALUES (?, ?)";
        jdbcTemplate.update(query, id, choice.getChoice());
    }
}
