package com.techelevator;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.FavoriteThings;

@Controller 
@SessionAttributes("survey")
public class HelloController {
	
	@RequestMapping("/")
	public String displayGreeting() {
		return "greeting";
	}
	
	@RequestMapping("/FavoriteThings/Page1")
	public String displayPage1() {

		return "FavoriteThings/Page1";
	}
	
	@RequestMapping("/FavoriteThings/Page2")
	public String displayPage2(ModelMap map, @RequestParam String color) {
		FavoriteThings survey = new FavoriteThings();
		survey.setColor(color);
		map.addAttribute("survey",  survey);

		return "FavoriteThings/Page2";
	}
	
	@RequestMapping("/FavoriteThings/Page3")
	public String displayPage3(ModelMap map, @RequestParam String food) {
		FavoriteThings survey = (FavoriteThings) map.get("survey");
		survey.setFood(food);

		return "FavoriteThings/Page3";
	}
	
	@RequestMapping("/FavoriteThings/Summary")
	public String displaySummary(ModelMap map, @RequestParam String season) {
		FavoriteThings survey = (FavoriteThings) map.get("survey");
		survey.setSeason(season);

		return "FavoriteThings/Summary";
	}
}
