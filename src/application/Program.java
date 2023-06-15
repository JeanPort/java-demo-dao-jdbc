package application;

import java.util.List;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("========TESTE SELLER 1==========");
		Seller seller = sellerDao.finfById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("========TESTE SELLER 2==========");
		
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}

}
