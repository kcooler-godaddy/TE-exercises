package com.techelevator.dao;

import com.techelevator.dao.model.Film;
import java.util.List;

/**
 * FilmDao
 */
public interface FilmDao {
    /**
     * Pass in a genre and a min movie length and a max movie length to get back a list of
     * movies. If either minLength or maxLength are 0, they are ignored.
     * 
     * @return a list of movie objects
     */
    public List<Film> getFilmsBetween(String genre, int minLength, int maxLength);
}