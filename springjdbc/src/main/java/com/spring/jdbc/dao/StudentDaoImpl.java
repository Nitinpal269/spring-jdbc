package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		//insert query
        String query="insert into Student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(), student.getName(), student.getCity());
		return r;
	}
	public int change(Student student) {
		// TODO Auto-generated method stub
		String query="update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	public int delete(int id) {
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,id);
		return r;
	}
	public Student getStudent(int studentId) {
		//select single student data
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	public List<Student> getAllStudents() {
		//select multiple student
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	}
	
	

