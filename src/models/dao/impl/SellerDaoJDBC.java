package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbExeption;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller finfById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller. *, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department department = instantiateDepartment(rs);
				Seller obj = instatiateSeller(rs, department);
				return obj;
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
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Seller instatiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller obj = new Seller();
		
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(department);
		
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		return department;
	}

}
