package com.jsp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.dto.Student;
import com.jsp.helper.Service;

public class StudentDao {
	Service helperClass = new Service();
	
//Insert
	public Student saveStudent(Student student) {
		Connection connection = helperClass.getConnection();
		String sql = "INSERT INTO student01 VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
			preparedStatement.execute();
			connection.close();
			System.out.println(student.getId()+" HAS BEEEN SAVED");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
}
	//delete
	public Student deleteStudent(Student student ) {
		Connection connection= helperClass.getConnection()  ;
		String sql= "DELETE FROM student01 WHERE ID= ?";
		
		 try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			connection.close();
			System.out.println("closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return student;
			
			
		
	}
	
	//update
	public Student updateStudent(Student student) {
		Connection connection= helperClass.getConnection();
		String sql= "UPDATE student01 SET NAME= ? WHERE ID=?";
		   try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			connection.close();
			System.out.println("closed");
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return student;
		
	}
	
	

}
