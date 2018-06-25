package com.techelevator.projects.model;

import java.util.List;

public interface EmployeeDAO {

	/**
	 * Gets all employees from the datastore and returns them in a List
	 * 
	 * @return all the employees as Employee objects in a List
	 */	
	public List<Employee> getAllEmployees();

	/**
	 * Find all employees whose names match the search strings. Names should
	 * contain both first and last name searches. If a search string is blank,
	 * ignore it. Be sure to use LIKE or ILIKE for proper search matching!
	 * 
	 * @param firstNameSearch the string to search for in the first_name, ignore if blank
	 * @param lastNameSearch the string to search for in the last_name, ignore if blank
	 * @return all employees whose name matches as Employee objects in a List
	 */
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch);

	/**
	 * Get all the employees that are in the department with the {@code id}.
	 * 
	 * @param id the id of the department
	 * @return all the employees from that department as Employee objects in a List
	 */
	public List<Employee> getEmployeesByDepartmentId(long id);

	/**
	 * Get all of the employees that aren't assigned to a project.
	 * 
	 * @return all the employees not on a project as Employee objects in a List
	 */
	public List<Employee> getEmployeesWithoutProjects();

	/**
	 * Get all of the employees that are on the project with the given {@code id}.
	 * 
	 * @param id the project id to get the employees from
	 * @return all the employees assigned to that project as Employee objects in a List
	 */
	public List<Employee> getEmployeesByProjectId(Long projectId);

	/**
	 * Change the given employee to the new department.
	 * 
	 * @param employeeId the employee's id that we want to move
	 * @param departmentId the employee's new department
	 */
	public void changeEmployeeDepartment(Long employeeId, Long departmentId);			
}
