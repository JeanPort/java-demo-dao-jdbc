package application;

import java.util.Date;

import models.entities.Department;
import models.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		Department objDepartment = new Department(1, "Cassino");
		
		System.out.println(objDepartment);
		
		Seller seller = new Seller(1, "Jean", "jean@gmail", new Date(), 2000.0, objDepartment);
		
		System.out.println(seller);
	}

}
