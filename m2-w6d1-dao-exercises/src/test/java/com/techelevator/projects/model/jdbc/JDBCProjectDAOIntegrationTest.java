package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JDBCProjectDAOIntegrationTest {
	
	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private JDBCProjectDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCProjectDAO(dataSource);
		//add new project
		String sqlAddNewProject = "insert into project (name, from_date, to_date) values ('alpha', '2000-01-01', '2020-01-01')";
		jdbcTemplate.update(sqlAddNewProject);
	}
	
	@After
	public void rollItBack() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_open_project_alpha() {
		List<Project> activeProjects = dao.getAllActiveProjects();
		boolean isReturned = false;
		for (Project project: activeProjects) {
			if(project.getName().equals("alpha")) isReturned = true; 
		}
		Assert.assertTrue(isReturned);
	}
	
	@Test
	public void does_not_return_closed_project() {
		String sqlAddNewProject = "insert into project (name, from_date, to_date) values ('beta', '2000-01-01', '2015-01-01')";
		jdbcTemplate.update(sqlAddNewProject);
		
		List<Project> activeProjects = dao.getAllActiveProjects();
		boolean isReturned = false;
		for (Project project: activeProjects) {
			if(project.getName().equals("beta")) isReturned = true; 
		}
		Assert.assertFalse(isReturned);
	}
	
	@Test
	public void does_not_return_nonstarted_project() {
		String sqlAddNewProject = "insert into project (name, to_date) values ('gamma', '2020-01-01')";
		jdbcTemplate.update(sqlAddNewProject);
		
		List<Project> activeProjects = dao.getAllActiveProjects();
		boolean isReturned = false;
		for (Project project: activeProjects) {
			if(project.getName().equals("gamma")) isReturned = true; 
		}
		Assert.assertFalse(isReturned);
	}
	
	@Test
	public void returns_openEnded_project() {
		String sqlAddNewProject = "insert into project (name, from_date) values ('delta', '2010-01-01')";
		jdbcTemplate.update(sqlAddNewProject);
		
		List<Project> activeProjects = dao.getAllActiveProjects();
		boolean isReturned = false;
		for (Project project: activeProjects) {
			if(project.getName().equals("delta")) isReturned = true; 
		}
		Assert.assertTrue(isReturned);
	}
	
	@Test
	public void adds_new_employee_to_project() {
		//insert new employee and get employeeId
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		String sqlGetEmployeeId = "select employee_id from employee where first_name = 'Sam' and last_name = 'Miller'";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployeeId);
		long employeeId = 0;
		if (result.next()) {
			employeeId = result.getLong("employee_id");
		}
		//get projectId
		String sqlGetProjectId = "select project_id from project where name = 'alpha'";
		SqlRowSet projectResult = jdbcTemplate.queryForRowSet(sqlGetProjectId);
		long projectId = 0;
		if (projectResult.next()) {
			projectId = projectResult.getLong("project_id");
		}
		//act
		dao.addEmployeeToProject(projectId, employeeId);
		//check if employee is linked to project
		boolean employeeAdded = false;
		String sqlSelectWhereEmployeeOnProject = "select * from project_employee where project_id = ? and employee_id = ?";
		SqlRowSet additionResult = jdbcTemplate.queryForRowSet(sqlSelectWhereEmployeeOnProject, projectId, employeeId);
		if(additionResult.next()) {
			employeeAdded = true;
		}
		//assert
		Assert.assertTrue(employeeAdded);
	}
	
	@Test
	public void add_and_remove_employee_from_project() {
		//insert new employee and get employeeId
		String sqlInsertNewEmployee = "insert into employee (department_id, first_name, last_name, birth_date, gender, hire_date) values (1, 'Sam', 'Miller', '1989-11-21', 'M', '2012-08-01')";
		jdbcTemplate.update(sqlInsertNewEmployee);
		String sqlGetEmployeeId = "select employee_id from employee where first_name = 'Sam' and last_name = 'Miller'";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployeeId);
		long employeeId = 0;
		if (result.next()) {
			employeeId = result.getLong("employee_id");
		}
		//get projectId
		String sqlGetProjectId = "select project_id from project where name = 'alpha'";
		SqlRowSet projectResult = jdbcTemplate.queryForRowSet(sqlGetProjectId);
		long projectId = 0;
		if (projectResult.next()) {
			projectId = projectResult.getLong("project_id");
		}
		//add employee to project
		dao.addEmployeeToProject(projectId, employeeId);
		//remove employee from project
		dao.removeEmployeeFromProject(projectId, employeeId);
		//check if employee is linked to project
		boolean employeeAdded = false;
		String sqlSelectWhereEmployeeOnProject = "select * from project_employee where project_id = ? and employee_id = ?";
		SqlRowSet additionResult = jdbcTemplate.queryForRowSet(sqlSelectWhereEmployeeOnProject, projectId, employeeId);
		if(additionResult.next()) {
			employeeAdded = true;
		}
		//assert
		Assert.assertFalse(employeeAdded);
	}

}
