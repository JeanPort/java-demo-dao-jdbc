package models.dao;

import java.util.List;

import models.entities.Seller;

public interface SellerDao {
	
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller finfById(Integer id);
	List<Seller> findAll();

}
