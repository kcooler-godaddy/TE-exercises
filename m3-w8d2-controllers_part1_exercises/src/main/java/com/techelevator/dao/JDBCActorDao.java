package com.techelevator.dao;

import com.techelevator.dao.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 * JDBCActorDao
 */
@Component
public class JDBCActorDao implements ActorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCActorDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

	@Override
	public List<Actor> getMatchingActors(String search) {
        List<Actor> matchingActors = new ArrayList<>();
        String actorSearchSql = "SELECT first_name, last_name FROM actor WHERE last_name ILIKE ? order by last_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(actorSearchSql, "%" + search + "%");
        while(results.next()) {
            matchingActors.add(mapRowToActor(results));
        }
        return matchingActors;
	}

	private Actor mapRowToActor(SqlRowSet results) {
		return new Actor(results.getString("first_name"), results.getString("last_name"));
	}

    
}