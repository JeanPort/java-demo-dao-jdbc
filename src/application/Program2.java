package application;

import java.util.List;

import models.dao.DaoFactory;
import models.dao.impl.DepartmentDaoJDBC;
import models.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDaoJDBC departmentDaoJDBC = DaoFactory.createDepartmentDao();
		
		List<Department> departmentList = departmentDaoJDBC.findAll();
		
		for (Department department : departmentList) {
			System.out.println(department);
		
		}
		
		Department dp = departmentDaoJDBC.finfById(2);
		
		System.out.println("Teste 2 " + dp);
		
		System.out.println();
		
		dp.setName("NovoEletronico");
		departmentDaoJDBC.update(dp);
		
		dp = departmentDaoJDBC.finfById(2);
		
		System.out.println("Teste 3 update " + dp);
		
		System.out.println();
		//departmentDaoJDBC.deleteById(1);
		
		
		
		//System.out.println("Delete"); // Delete falta arrumar!!
		
		
		System.out.println();
		
		Department newDepartment = new Department(null, "automoveis");
		departmentDaoJDBC.insert(newDepartment);
		
		departmentList = departmentDaoJDBC.findAll();
		
		for (Department department : departmentList) {
			System.out.println(department);
		
		}
	}

}
