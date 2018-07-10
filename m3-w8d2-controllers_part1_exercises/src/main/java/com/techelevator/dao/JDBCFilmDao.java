package com.techelevator.dao;

import com.techelevator.dao.model.Film;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCFilmDao implements FilmDao
 */
@Component
public class JDBCFilmDao implements FilmDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCFilmDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

	@Override
	public List<Film> getFilmsBetween(String genre, int minLength, int maxLength) {
        List<Film> matchingFilms = new ArrayList<>();
        
        String filmSearchSql = "SELECT title, description, release_year, length, rating FROM film " +
        "JOIN film_category ON film_category.film_id = film.film_id JOIN category ON category.category_id = film_category.category_id "+
        "WHERE category.name = ? AND length BETWEEN ? AND ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(filmSearchSql, genre, minLength, maxLength);
        while(results.next()) {
            matchingFilms.add(mapRowToFilm(results));
        }
        return matchingFilms;
    }

	private Film mapRowToFilm(SqlRowSet results) {
        Film filmRow = new Film();
        filmRow.setTitle(results.getString("title"));
        filmRow.setDescription(results.getString("description"));
        filmRow.setReleaseYear(results.getInt("release_year"));
        filmRow.setLength(results.getInt("length"));
        filmRow.setRating(results.getString("rating"));
        return filmRow;
	}
    
    

    
}