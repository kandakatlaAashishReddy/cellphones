package aashish.dao;

import java.util.List;

import aashish.model.Supplier;

public interface SupplierDAOInt {
	void addSupplier(Supplier sup);
	void deleteSupplier(String sid);
	void updateSupplier(Supplier sup);
	List<Supplier>getSupplier();
	Supplier getSupplierByID(String sid);

}
