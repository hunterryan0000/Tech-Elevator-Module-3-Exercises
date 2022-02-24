package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE first_name ILIKE ?  And last_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while (results.next()) {
//			Employee employee = mapRowToEmployee(results);
//			employees.add(employee);
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List <Employee> employees = new ArrayList<>();
		String sql = "SELECT e.employee_id, e.department_id, first_name, last_name, birth_date, hire_date , pe.project_id  "
				+ "FROM employee e " + "LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id "
				+ "WHERE pe.project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List <Employee> employees = new ArrayList<>();
		String sql = "SELECT e.employee_id, e.department_id, first_name, last_name, birth_date, hire_date , pe.project_id  "
				+ "FROM employee e " + "LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id "
				+ "WHERE pe.project_id is Null;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
//		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
//		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		Date date = rowSet.getDate("birth_date");
		if (date != null) {
			employee.setBirthDate(date.toLocalDate());
		}
		Date date2 = rowSet.getDate("hire_date");
		if (date2 != null) {
			employee.setHireDate(date2.toLocalDate());
		}

		return employee;
	}


}
