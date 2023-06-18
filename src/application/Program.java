package application;

import java.util.Date;
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
		
		System.out.println();
		System.out.println("========TESTE SELLER 3 find all==========");
		
		List<Seller> list2 = sellerDao.findAll();
		
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("========TESTE SELLER 4 Insert==========");
		Seller seller2 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
		sellerDao.insert(seller2);
		
		System.out.println("Inserted! New id = " + seller2.getId());
	}

}
