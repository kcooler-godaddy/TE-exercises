package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.*;

public class JDBCEmployeeDAOIntegrationTest {
	
	private static  SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass 
	public static void closeDataSource() {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollItBack() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_list_of_correct_size_when_get_all_employees() {
		Integer numOfEmployees = 0;
		SqlRowSet result = jdbcTemplate.queryForRowSet("select count(*) as ecount from employee");
		if(result.next()) {
			numOfEmployees = result.getInt("ecount");
		}
		
		List<Employee> employees = dao.getAllEmployees();
		
		Assert.assertEquals(numOfEmployees,  new Integer(employees.size()));
	}
	
	@Test
	public void returns_employee_searched_by_first_and_last_name() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Adams', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		
		List<Employee> employees = dao.searchEmployeesByName("Sam", "Adams");
		Employee employee = employees.get(0);
		
		Assert.assertEquals(1, employee.getDepartmentId());
		Assert.assertEquals("Sam",  employee.getFirstName());
		Assert.assertEquals('M', employee.getGender());
	}
	
	@Test
	public void returns_employee_searched_by_last_name() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Adams', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		
		List<Employee> employees = dao.searchEmployeesByName("", "Adams");
		Employee employee = employees.get(0);
		
		Assert.assertEquals(1, employee.getDepartmentId());
		Assert.assertEquals("Sam",  employee.getFirstName());
		Assert.assertEquals('M', employee.getGender());
	}
	
	@Test
	public void returns_2_employees_with_same_first_name() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Adams', '1989-11-21', 'M', '2012-08-01')";
		String sqlInsertNewEmployee2 = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";

		jdbcTemplate.update(sqlInsertNewEmployee);
		jdbcTemplate.update(sqlInsertNewEmployee2);
		
		List<Employee> employees = dao.searchEmployeesByName("Sam", "");
		Employee employee = employees.get(0);
		Employee employee2 = employees.get(1);
		
		Assert.assertEquals(1, employee.getDepartmentId());
		Assert.assertEquals("Sam",  employee.getFirstName());
		Assert.assertEquals('M', employee.getGender());
		Assert.assertEquals(1, employee2.getDepartmentId());
		Assert.assertEquals("Sam",  employee2.getFirstName());
		Assert.assertEquals('M', employee2.getGender());
	}
	
	@Test
	public void returns_correct_count_of_employees_in_department_and_increases_when_added() {
		int numOfEmployees = 0;
		SqlRowSet result = jdbcTemplate.queryForRowSet("select count(*) as ecount from employee where department_id = 1");
		if(result.next()) {
			numOfEmployees = result.getInt("ecount");
		}
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		
		List<Employee> employeesInDepartment1 = dao.getEmployeesByDepartmentId(1);
		
		Assert.assertEquals(numOfEmployees + 1, employeesInDepartment1.size());
	}
	
	@Test
	public void returns_employee_without_project() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		
		List<Employee> employees = dao.getEmployeesWithoutProjects();
		Employee employee = null;
		for (Employee emp: employees) {
			if (emp.getFirstName().equals("Sam") && emp.getLastName().equals("Miller")) employee = emp;
		}
		Assert.assertEquals("Sam",  employee.getFirstName());
		Assert.assertEquals(1, employee.getDepartmentId());
	}
	
	@Test
	public void returns_employee_working_on_project_id_1() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		String sqlInsertEmployeeProject = "insert into project_employee (project_id, employee_id) values (1, (select employee_id from employee where first_name = 'Sam' and last_name = 'Miller'))";
		jdbcTemplate.update(sqlInsertEmployeeProject);
		
		List<Employee> employees = dao.getEmployeesByProjectId(1l);
		Employee employee = null;
		for (Employee emp: employees) {
			if (emp.getFirstName().equals("Sam") && emp.getLastName().equals("Miller")) employee = emp;
		}
		Assert.assertEquals("Sam",  employee.getFirstName());
		Assert.assertEquals(1, employee.getDepartmentId());
	}
	
	@Test
	public void updates_department_to_2() {
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);

		String sqlGetEmployeeId = "select employee_id from employee where first_name = 'Sam' and last_name = 'Miller'";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployeeId);
		long employeeId = 0;
		if (result.next()) {
			employeeId = result.getLong("employee_id");
		}
		dao.changeEmployeeDepartment(employeeId, 2l);
		List<Employee> employees = dao.getEmployeesByDepartmentId(2);
		Employee targetEmployee = null;
		for (Employee employee: employees) {
			if (employee.getId() == employeeId) targetEmployee = employee;
		}
		Assert.assertEquals(employeeId, (long)targetEmployee.getId());
	}
	
//	
//	
//	private void assertEmployeesAreEqual(Employee expected, Employee actual) {
//		Assert.assertEquals(expected.getId(), actual.getId());
//		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
//		Assert.assertEquals(expected.getLastName(), actual.getLastName());
//		Assert.assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
//		Assert.assertEquals(expected.getBirthDay(), actual.getBirthDay());
//		Assert.assertEquals(expected.getGender(), actual.getGender());
//		Assert.assertEquals(expected.getHireDate(), actual.getHireDate());
//	}
//	
//	private Employee getEmployee(long department_id, String first_name, String last_name, LocalDate birth_date, char gender, LocalDate hire_date) {
//		Employee employee = new Employee();
//		
//		employee.setBirthDay(birth_date);
//		employee.setDepartmentId(department_id);
//		employee.setBirthDay(birth_date);
//		employee.setFirstName(first_name);
//		employee.setLastName(last_name);
//		employee.setGender(gender);
//		
//		return employee;
//	}

}


