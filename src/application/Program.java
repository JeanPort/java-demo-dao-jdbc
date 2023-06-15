package application;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		Department objDepartment = new Department(1, "Cassino");
		
		System.out.println(objDepartment);
		
		
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.finfById(3);
		
		System.out.println(seller);
	}

}
