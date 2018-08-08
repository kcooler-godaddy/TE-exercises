package com.techelevator.critter.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCUserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveUser(String userName, String password) {
		String sqlSaveUser = "INSERT INTO app_user(user_name, password) VALUES (?, ?)";
		jdbcTemplate.update(sqlSaveUser, userName, password);
	}

	@Override
	public boolean searchForUsernameAndPassword(String userName, String password) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM app_user "+
							      "WHERE UPPER(user_name) = ? "+
							      "AND password = ?";
		
		return jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase(), password).next();
	}

	@Override
	public void updatePassword(String userName, String password) {
		String sqlUpdatePassword = "UPDATE app_user SET password = ? WHERE user_name = ?";
		jdbcTemplate.update(sqlUpdatePassword, password, userName);
	}

}
