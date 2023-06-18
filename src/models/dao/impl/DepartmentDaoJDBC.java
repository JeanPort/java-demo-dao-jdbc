package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbExeption;
import models.dao.DepartmentDao;
import models.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			
		} catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		finally {
			DB.closeStatment(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+ " SET Name = ? "
					+ "WHERE Id = ? ");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		finally {
			DB.closeStatment(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
	
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM department WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		} 
		finally {
			DB.closeStatment(st);
		}
	
	}

	@Override
	public Department finfById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			
			if (rs.next()) {
				Department department = new Department(rs.getInt("Id"), rs.getString("Name"));
				return department;
			}
			return null;
			
			
		} catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department ORDER BY Name");
			
			rs = st.executeQuery();
			List<Department> departments = new ArrayList<>();
			
			while(rs.next()) {
				Department department = new Department(rs.getInt(1), rs.getString(2));
				departments.add(department);
			}
			return departments;
		} catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
		
	}
	
	

}
