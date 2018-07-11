package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;
    
	@RequestMapping("/searchCustomerForm")
	public String showSearchCustomerForm() {
		return "searchCustomerForm";
	}
	
	@RequestMapping("/customerList")
	public String showCustomerList(HttpServletRequest request) {
		String search = request.getParameter("name");
		String sort = request.getParameter("sort");
		List<Customer> customers = customerDao.searchAndSortCustomers(search, sort);
		request.setAttribute("customers",  customers);
		
		return "customerList";
	}

}