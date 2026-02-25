package com.klu.S1SPCRUD;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {
	private Student std;
	
	public Student getStd() {
		return std;
	}
	
	public void setStd(Student std) {
		this.std = std;
	}

	/*private Connection conn;

    public StudentDaoImpl() {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","root");

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }*/
	
	@Override
	public void insert(Student s) {
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","root");
		PreparedStatement ps = conn.prepareStatement("insert into student values(?,?)");
		ps.setInt(1,s.getSid());
		ps.setString(2,s.getSname());
		
		ps.executeUpdate();
		System.out.println("Successfully inserted");
		}
		catch(SQLException e) {
			System.out.println("Insert Error: " + e.getMessage());
		}
		
	}


	@Override
	public Student get() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","root");
			Statement stmt = conn.createStatement();
			ResultSet  rs = stmt.executeQuery("select * from student limit 1");
			
			if(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				return s;
			}
		}catch(SQLException e) {
			System.out.println("Retrieve Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Student s) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","root");
			PreparedStatement ps = conn.prepareStatement("update student set sname=? where sid=?");
			ps.setString(1,s.getSname());
			ps.setInt(2,s.getSid());
			ps.executeUpdate();
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("update error: "+ e.getMessage());
		}
		
	}

	@Override
	public void delete() {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from student");
			System.out.println("Deleted Successfully");
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("delete error: " + e.getMessage());
		}
	}	
}
