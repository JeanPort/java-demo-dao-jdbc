package application;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("========TESTE SELLER 1==========");
		
		Seller seller = sellerDao.finfById(3);
		
		System.out.println(seller);
	}

}
