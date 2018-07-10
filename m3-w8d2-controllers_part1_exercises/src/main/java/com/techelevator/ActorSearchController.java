package com.techelevator;

import java.util.Map;

import com.techelevator.dao.ActorDao;

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

	/* What request mapping do we want here */
	public String showSearchActorForm() {
		return null;
	}

	/* What about here? */
	public String searchActors(/* What arguments go here to get parameters from the page? */) {
		/* Call the model and pass values to the jsp */
		return null;
	}
}
