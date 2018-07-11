package com.techelevator;

import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
	
	@Autowired
	private ReviewDao reviewDAO;

	@RequestMapping("/")
	public String displayHomePage(ModelMap map) {
		map.addAttribute("reviews",  reviewDAO.getAllReviews());
		return "homePage";
	}
	
	@RequestMapping("/writeReview")
	public String displayWriteReview() {
		return "writeReview";
	}
	
	@RequestMapping(path="/submitReview", method=RequestMethod.POST)
	public String displaySumbmitReview(Review review, HttpServletRequest request) {
		review.setDateSubmitted(LocalDateTime.now());
		review.setRating(Integer.parseInt(request.getParameter("rating")));
		System.out.println(review.getText());
		reviewDAO.save(review);
		
		return "redirect:/";
	}

}
