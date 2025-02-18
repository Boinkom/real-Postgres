package com.roks.realpostgres.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EntireProjectRepo {

    private final JdbcTemplate jdbcTemplate;

    public EntireProjectRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getTop10WalkingUsersFromDb() {
        String sql = """
            SELECT user_login 
            FROM WALKS 
            GROUP BY user_login 
            ORDER BY COUNT(*) DESC 
            LIMIT 10;
        """;
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
