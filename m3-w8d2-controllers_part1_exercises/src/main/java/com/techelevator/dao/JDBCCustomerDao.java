package com.techelevator.dao;

import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Customer> searchAndSortCustomers(String search, String sort) {
		String sqlSelectCustomerByNameAndSort = "select * from customer WHERE last_name ILIKE ? or first_name IlIKE ? order by ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectCustomerByNameAndSort, "%" + search + "%", "%" + search + "%", sort);
		List<Customer> customers = new ArrayList<Customer>();
		while(result.next()) {
			customers.add(mapRowToCustomer(result));
		}
		return customers;
	}

    private Customer mapRowToCustomer(SqlRowSet result) {
    	Customer customer = new Customer();
    	customer.setActive(result.getBoolean("activebool"));
    	customer.setEmail(result.getString("email"));
    	customer.setFirstName(result.getString("first_name"));
    	customer.setLastName(result.getString("last_name"));
    	return customer;
    }
}