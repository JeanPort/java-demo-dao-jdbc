package models.dao;

import models.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDaoJDBC createSellerDao() {
		return new SellerDaoJDBC();
	}

}
