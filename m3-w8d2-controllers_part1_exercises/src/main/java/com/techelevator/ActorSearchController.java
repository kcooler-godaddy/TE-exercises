package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping("/searchActorForm")
	public String showSearchActorForm() {
		return "searchActorForm";
	}

	@RequestMapping("/actorList")
	public String searchActors(HttpServletRequest request) {
		
		String search = request.getParameter("actorSearch");
		List<Actor> actors = actorDao.getMatchingActors(search);
		request.setAttribute("actors",  actors);

		return "actorList";
	}
}
