package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> departments = new ArrayList<Department>();
		String selectAllDepartments = "select * from department";
		SqlRowSet result = jdbcTemplate.queryForRowSet(selectAllDepartments);
		
		while(result.next()) {
			departments.add(mapRowToDepartment(result));
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> departments = new ArrayList<Department>();
		String selectAllDepartmentsWithName = "select * from department where name like '%'||?||'%'";
		SqlRowSet result = jdbcTemplate.queryForRowSet(selectAllDepartmentsWithName, nameSearch);
		
		while(result.next()) {
			departments.add(mapRowToDepartment(result));
		}
		return departments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "update department set name = ? where department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "insert into department(department_id, name) values (?, ?)";
		newDepartment.setId(getNextDepartmentID());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;
		String sqlFindDepartmentById = "select * from department where id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlFindDepartmentById);
		if (result.next()) {
			theDepartment = mapRowToDepartment(result);
		}
		return theDepartment;
	}
	
	private Department mapRowToDepartment(SqlRowSet result) {
		Department department = new Department();
		department.setId(result.getLong("department_id"));
		department.setName(result.getString("name"));
		return department;
	}
	
	private long getNextDepartmentID() {
		SqlRowSet nextIDResult = jdbcTemplate.queryForRowSet("select nextval('seq_department_id')");
		if (nextIDResult.next()) {
			return nextIDResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

}
