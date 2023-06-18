package models.dao;

import db.DB;
import models.dao.impl.DepartmentDaoJDBC;
import models.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDaoJDBC createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDaoJDBC createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
