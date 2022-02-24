package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sql =
				"SELECT * FROM department " +
						"WHERE department_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			// Only expect one department, so a single if-next() confirms
			department = mapRowToDepartment(results);
		}
		return department;
	}
	@Override
	public List<Department> getAllDepartments() {

		List<Department> departments = new ArrayList<>();
		String sql = "SELECT * FROM department;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Department department = mapRowToDepartment(results);
			departments.add(department);
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		updatedDepartment.setName("Test");
		String sql = "UPDATE department SET name = ? WHERE department_id = ?;";
		int  numberOfRows =
				jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
		if (numberOfRows == 1) {
			System.out.println(updatedDepartment);
		}
		System.out.println("Update failed");
	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department department = new Department();
		department.setId(rowSet.getLong("department_id"));
		department.setName(rowSet.getString("name"));
		if (rowSet.wasNull()) {
			department.setId(null);
		} return department;
	}

}
