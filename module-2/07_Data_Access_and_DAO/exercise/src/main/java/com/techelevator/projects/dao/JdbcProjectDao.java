package com.techelevator.projects.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
						"FROM project " +
						"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Project project = mapRowToProject(results);
			projects.add(project);
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES (?, ?, ?) RETURNING project_id;";
		Long project = jdbcTemplate.queryForObject(sql, Long.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(project);
		return newProject;

	}

	@Override
	public void deleteProject(Long projectId) {
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE project_id = ?;";
// Delete all the projects related to the project_employee
		jdbcTemplate.update(deleteProjectEmployeeSql, projectId);
// Safe to delete the project
		deleteProjectEmployeeSql = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectEmployeeSql, projectId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		Date date = rowSet.getDate("from_date");
		if (date != null) {
			project.setFromDate(date.toLocalDate());
		}
		Date date2 = rowSet.getDate("to_date");
		if (date2 != null) {
			project.setToDate(date2.toLocalDate());
		}
		return project;
	}
	

}


