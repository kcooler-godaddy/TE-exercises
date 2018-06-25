package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String selectAllFromEmployee = "select * from employee";
		SqlRowSet result = jdbcTemplate.queryForRowSet(selectAllFromEmployee);
		
		while(result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<Employee>();
		String selectAllFromEmployeeWithFirstAndLastName = "select * from employee where first_name like '%'||?||'%' and last_name like '%'||?||'%'";
		SqlRowSet result = jdbcTemplate.queryForRowSet(selectAllFromEmployeeWithFirstAndLastName, firstNameSearch, lastNameSearch);
		
		while(result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employees = new ArrayList<Employee>();
		String selectAllEmployeeByDepartmentId = "select * from employee where department_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(selectAllEmployeeByDepartmentId, id);
		while(result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		String sqlSelectEmployeeWithoutProject = "select * from employee left join project_employee on employee.employee_id = project_employee.employee_id where project_id is null";
		List<Employee> employees = new ArrayList<Employee>();
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectEmployeeWithoutProject);
		while(result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<Employee>();
		String sqlSelectEmployeeByProjectId = "select * from employee join project_employee on employee.employee_id = project_employee.employee_id where project_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectEmployeeByProjectId, projectId);
		while(result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return new ArrayList<>();
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlUpdateEmployeeDepartmentId = "update employee set department_id = ? where employee_id = ?";
		jdbcTemplate.update(sqlUpdateEmployeeDepartmentId, departmentId, employeeId);
	}
	
	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		
		employee.setId(result.getLong("employee_id"));
		employee.setDepartmentId(result.getLong("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDay(result.getDate("birth_date").toLocalDate());
		employee.setGender(result.getString("gender").charAt(0));
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		
		return employee;
	}

}
