package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;
    
    @RequestMapping("/searchFilmForm")
    public String showFilmSearchForm() {
        return "searchFilmForm";
    }
    
    @RequestMapping("/filmList")
    public String searchFilms(HttpServletRequest request) {
    	int minLength = 0;
    	int maxLength = 999;
		String minStrLength = request.getParameter("minLength");
		String maxStrLength = request.getParameter("maxLength");
		if (!minStrLength.equals("")) minLength = Integer.parseInt(minStrLength);
		if (!maxStrLength.equals("")) maxLength = Integer.parseInt(maxStrLength);
		String genre = request.getParameter("genre");
		
		List<Film> films = filmDao.getFilmsBetween(genre, minLength, maxLength);
		request.setAttribute("films",  films);
        return "filmList";
    }
    
    
}