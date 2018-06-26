package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JDBCDepartmentDAOIntentegrationTest {
	
	private static  SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
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
		dao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollItBack() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_list_of_correct_size_when_get_all_departments() {
		Integer numOfDepartments = 0;
		SqlRowSet result = jdbcTemplate.queryForRowSet("select count(*) as dcount from department");
		if(result.next()) {
			numOfDepartments = result.getInt("dcount");
		}
		
		List<Department> departments = dao.getAllDepartments();
		
		Assert.assertEquals(numOfDepartments,  new Integer(departments.size()));
	}
	
	@Test
	public void creates_department_and_returns_it_searched_by_name() {
		Department testDepartment = getDepartment("Logistics");
		dao.createDepartment(testDepartment);
		
		List<Department> departments = dao.searchDepartmentsByName("Logistics");
		
		Assert.assertEquals("Logistics",  departments.get(0).getName());
	}
	
	@Test
	public void returns_updated_department_from_after_added_to_database() {
		Department originalDepartment = getDepartment("Mathematic");
		dao.createDepartment(originalDepartment);
		List<Department> departments = dao.searchDepartmentsByName("Mathematic");
		Department updatedDepartment = departments.get(0);
		updatedDepartment.setName("Mathematics");
		
		dao.saveDepartment(updatedDepartment);
		
		List<Department> updatedDepartments = dao.searchDepartmentsByName("Mathematics");
		Department savedDepartment = updatedDepartments.get(0);
		
		assertDepartmentsAreEqual(updatedDepartment, savedDepartment);
	}
	
	@Test
	public void returns_department_from_id_of_department_created_and_searched_for() {
		Department testDepartment = getDepartment("HR");
		dao.createDepartment(testDepartment);
		List<Department> searchDepartments = dao.searchDepartmentsByName("HR");
		Department searchDepartment = searchDepartments.get(0);
		long searchId = searchDepartment.getId();
		
		Department gotByIdDepartment = dao.getDepartmentById(searchId);
		
		assertDepartmentsAreEqual(searchDepartment, gotByIdDepartment);
	}
	
	
	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getId(),  actual.getId());
	}
	
	private Department getDepartment(String name) {
		Department department = new Department();
		department.setName(name);
		return department;
	}

}
